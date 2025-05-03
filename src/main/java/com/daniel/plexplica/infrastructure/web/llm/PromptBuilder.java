package com.daniel.plexplica.infrastructure.web.llm;
import com.daniel.plexplica.domain.DTO.*;
import com.daniel.plexplica.domain.modelo.Metadados;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import com.daniel.plexplica.infrastructure.antlr.util.LimpezaDeSql;


import java.io.InputStream;
import java.util.*;

@Component
public class PromptBuilder {

    private final ObjectMapper mapper = new ObjectMapper();

    public String construirPrompt(String sql, Metadados metadados) {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("explicacoes/modeloPrompt.json")) {
            Map<String, String> template = mapper.readValue(is, new TypeReference<>() {});

            StringBuilder prompt = new StringBuilder();            // Contexto base (pode ser algo como "Você é um assistente técnico experiente em SQL.")
            // Contexto base vindo do template
            prompt.append(template.get("contexto"))
                    .append("\n\n")

                    // Metadados do comando
                    .append("### Metadados fornecidos:\n")
                    .append("- Localização: ").append(metadados.getLocalizacao()).append("\n")
                    .append("- Objetivo: ").append(metadados.getObjetivo()).append("\n")
                    .append("- Memo: ").append(metadados.getMemo()).append("\n\n")

                    // Introdução com empatia e clareza
                    .append("Pense que você está explicando esse código para um colega novo na equipe.\n")
                    .append("Ele entende lógica, mas nunca viu esse processo.\n")
                    .append("Use uma voz acolhedora e clara. Guie com atenção, como quem compartilha o que sabe — não como quem corrige.\n\n")

                    // Instrução para storytelling técnico
                    .append("Explique o código a seguir como um narrador técnico experiente, guiando o leitor por uma jornada pedagógica.\n")
                    .append("Utilize títulos relevantes conforme o fluxo do código.\n")
                    .append("Mostre apenas os trechos essenciais usando blocos de código markdown (```sql) como ilustração.\n")
                    .append("Não repita o código inteiro. Foque em trechos que ajudem na compreensão.\n")
                    .append("A linguagem deve ser precisa, mas próxima. Técnica, sem ser fria.\n\n")

                    // Aprofundamento técnico com toque humano
                    .append("Durante a explicação, aprofunde o que cada trecho faz, especialmente:\n")
                    .append("- comandos `SELECT ... INTO`\n")
                    .append("- estruturas `IF ... THEN ... ELSE`\n")
                    .append("- loops, exceções e validações\n")
                    .append("Evite frases genéricas como 'executa uma operação'. Diga o que exatamente está sendo feito.\n")
                    .append("Sempre explique o *porquê* de cada verificação, não apenas o que está sendo comparado.\n")
                    .append("Evite dizer apenas 'verifica uma condição'.\n")
                    .append("Diga o que está sendo validado e qual a intenção por trás dessa lógica.\n")
                    .append("Clareza é um ato de gentileza.\n\n")

                    .append("⚠️ Sempre que encontrar `UPDATE`, `DELETE` ou `INSERT`, destaque como ponto de atenção.\n")
                    .append("Explique seus impactos com cuidado.\n\n")

                    .append("A seguir está o código a ser analisado:\n\n")
                    .append("```sql\n")
                    .append(LimpezaDeSql.gerarVersaoCompacta(sql)).append("\n")
                    .append("```\n");
            return prompt.toString();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar template do prompt", e);
        }

    }
    public String construirPromptComChat(String explicacaoOriginal, List<MensagemChatDTO> historico, String perguntaAtual) {
        StringBuilder prompt = new StringBuilder();

        prompt.append("Você é um assistente técnico treinado para explicar comandos SQL com base em uma explicação já existente.\n");
        prompt.append("Explicação original:\n").append(explicacaoOriginal).append("\n\n");

        if (historico != null && !historico.isEmpty()) {
            prompt.append("Histórico da conversa:\n");
            for (MensagemChatDTO msg : historico) {
                prompt.append("Usuário: ").append(msg.getPergunta()).append("\n");
                prompt.append("Assistente: ").append(msg.getResposta()).append("\n");
            }
            prompt.append("\n");
        }

        prompt.append("Nova pergunta do usuário:\n").append(perguntaAtual).append("\n");
        prompt.append("Responda de forma complementar, evitando repetir a explicação original.");

        return prompt.toString();
    }

}


