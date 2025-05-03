package com.daniel.plexplica.infrastructure.web.llm;

import com.daniel.plexplica.domain.DTO.ExplicacaoDTO;
import com.daniel.plexplica.domain.modelo.Metadados;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.nio.file.Paths;


@Component
public class GroqLlmClient implements LlmClient {
    private static final String NIVEL_PADRAO = "Técnico";
    private static final String ROLE_USER = "user";

    private final WebClient webClient;
    private final PromptBuilder promptBuilder;

    @Value("${groq.api.key}")
    private String apiKey;

    @Value("${groq.api.endpoint}")
    private String endpoint;

    @Value("${groq.model.default}")
    private String modeloPadrao = "llama3-70b-8192";


    public GroqLlmClient(WebClient.Builder builder, PromptBuilder promptBuilder) {
        this.webClient = builder.build();
        this.promptBuilder = promptBuilder;
    }

    @Override
    public String gerarRespostaSimples(String prompt, String modeloLLM, Double temperatura) {
        Map<String, Object> resposta = executaRequisicaoLLM(prompt, modeloLLM, temperatura);
        return extrairConteudoResposta(resposta);
    }


    @Override
    public ExplicacaoDTO gerarExplicacao(String sql, Metadados metadados, String modeloLLM, Double temperatura) {

        //Gera o prompt usando o PromptBuilder
        String prompt = promptBuilder.construirPrompt(sql,metadados);

        String modeloEfetivo =modeloLLM != null ? modeloLLM : modeloPadrao;

        Map<String, Object> resposta = executaRequisicaoLLM(prompt,modeloEfetivo,temperatura);
        String conteudoResposta = extrairConteudoResposta(resposta);

        return criarExplicaoDTO(conteudoResposta,modeloEfetivo);
    }
    @PostConstruct
    public void init() {
        System.out.println("Modelo LLM: " + modeloPadrao);
        System.out.println("Temperatura padrão: " + 0.7); // Se necessário, você pode também adicionar um valor default aqui.
    }

    private Map<String, Object> executaRequisicaoLLM(String prompt, String modelo, Double temperatura) {
        String modeloEfetivo = (modelo != null) ? modelo : modeloPadrao;
        double temperaturaEfetiva = (temperatura != null) ? temperatura : 0.7;

        Map<String, Object> requestBody = Map.of(
                "model", modeloEfetivo,
                "temperature", temperaturaEfetiva,
                "messages", List.of(
                        Map.of("role", ROLE_USER, "content", prompt)
                )
        );

        //System.out.println("Request JSON: " + requestBody);  // LOG do JSON montado

        salvarPromptParaDebug(requestBody); // 👉 Salva o JSON no disco antes de enviar


        return webClient.post()
                .uri(endpoint)
                .header("Authorization", "Bearer " + apiKey)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }


    private String extrairConteudoResposta(Map<String, Object> resposta) {
        System.out.println("Resposta completa: " + resposta);  // Log da resposta completa

        // Verifica a estrutura da chave "choices"
        Object choices = resposta.get("choices");
        System.out.println("Choices: " + choices);  // Log da chave "choices"


        // Tenta extrair o conteúdo com a estrutura correta
        if (choices instanceof List) {
            List<Map<String, Map<String, String>>> choiceList = (List<Map<String, Map<String, String>>>) choices;
            if (!choiceList.isEmpty()) {
                Map<String, String> message = choiceList.get(0).get("message");
                if (message != null) {
                    return message.get("content");
                }
            }
        }

        // Retorna um erro ou conteúdo padrão se não encontrar a estrutura esperada
        return "Conteúdo não encontrado na resposta da LLM.";
    }

    private ExplicacaoDTO criarExplicaoDTO(String conteudo,String modelo){

        ExplicacaoDTO explicacao = new ExplicacaoDTO();
        explicacao.setExplicacao(conteudo);
        explicacao.setAlertas(Collections.emptyList());
        explicacao.setRecomendacoes(Collections.emptyList());
        explicacao.setTags(Collections.emptyList());
        explicacao.setNivel(NIVEL_PADRAO);
        explicacao.setModeloLLM(modelo);

        return explicacao;

    }

    private void salvarPromptParaDebug(Map<String, Object> requestJson) {
        try {
            ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
            String jsonFormatado = mapper.writeValueAsString(requestJson);
            Path path = Paths.get("prompt_gerado.json");
            Files.writeString(path, jsonFormatado, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar prompt para debug", e);
        }
    }

}
