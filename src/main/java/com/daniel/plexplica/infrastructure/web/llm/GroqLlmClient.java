package com.daniel.plexplica.infrastructure.web.llm;

import com.daniel.plexplica.domain.DTO.ExplicacaoDTO;
import com.daniel.plexplica.domain.modelo.Metadados;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;
import java.util.Map;

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
    public ExplicacaoDTO gerarExplicacao(String sql, Metadados metadados, String modeloLLM, Double temperatura) {

        //Gera o prompt usando o PromptBuilder
        String prompt = promptBuilder.construirPrompt(sql,metadados);
        String modeloEfetivo =modeloLLM != null ? modeloLLM : modeloPadrao;

        Map<String, Object> resposta = executaRequisicaoLLM(prompt,modeloEfetivo,temperatura);
        String conteudoResposta = extrairConteudoResposta(resposta);

        return criarExplicaoDTO(conteudoResposta,modeloEfetivo);
    }

    private Map<String, Object> executaRequisicaoLLM(String prompt, String modelo, Double temperatura) {
        Map<String, Object> requestBody = Map.of(
                "model", modelo,
                "temperature", temperatura,
                "messages", List.of(
                        Map.of("role", ROLE_USER, "content", prompt)
                )

        );

        return webClient.post()
                .uri(endpoint)
                .header("Authorization", "Bearer " + apiKey)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }

    private String extrairConteudoResposta(Map<String,Object> resposta){
        return ((List<Map<String,Map<String,String>>>) resposta.get("choices"))
                .get(0)
                .get("message")
                .get("content");
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
}
