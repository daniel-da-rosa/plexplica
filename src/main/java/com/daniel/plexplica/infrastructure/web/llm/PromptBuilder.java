package com.daniel.plexplica.infrastructure.web.llm;
import com.daniel.plexplica.domain.modelo.Metadados;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;


import java.io.InputStream;
import java.util.Map;

@Component
public class PromptBuilder {

    private final ObjectMapper mapper = new ObjectMapper();

    public String construirPrompt(String sql, Metadados metadados) {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("explicacoes/modeloPrompt.json")) {
            Map<String, String> template = mapper.readValue(is, new TypeReference<>() {});

            StringBuilder prompt = new StringBuilder();
            prompt.append(template.get("contexto")).append("\n\n");

            prompt.append("### Metadados fornecidos:\n");
            prompt.append("- Localização: ").append(metadados.getLocalizacao()).append("\n");
            prompt.append("- Objetivo: ").append(metadados.getObjetivo()).append("\n");
            prompt.append("- Memo: ").append(metadados.getMemo()).append("\n\n");

            prompt.append(template.get("formato")).append("\n\n");

            prompt.append("### Comando SQL/PLSQL a ser analisado:\n\n");
            prompt.append(sql);

            return prompt.toString();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar template do prompt", e);
        }
    }
}


