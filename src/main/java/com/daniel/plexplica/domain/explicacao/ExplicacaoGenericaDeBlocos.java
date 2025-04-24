package com.daniel.plexplica.domain.explicacao;

import com.daniel.plexplica.domain.DTO.ExplicacaoDTO;
import com.daniel.plexplica.domain.modelo.Bloco;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class ExplicacaoGenericaDeBlocos implements ExplicacaoDeBloco {

    private final String tipoBloco;
    private final ObjectMapper mapper = new ObjectMapper();

    public ExplicacaoGenericaDeBlocos(String tipoBloco) {
        this.tipoBloco = tipoBloco;
    }

    @Override
    public boolean aplica(Bloco bloco) {
        if (bloco == null || bloco.getTipo() == null) {
            return false;
        }
        return bloco.getTipo().equalsIgnoreCase(tipoBloco);
    }

    @Override
    public String explicar(Bloco bloco) {
        String caminho = "explicacoes/" + tipoBloco.replace(" ", "_") + ".json";
        System.out.println("🔍 Procurando por: " + tipoBloco);

        try (InputStream is = getClass().getClassLoader().getResourceAsStream(caminho)) {
            if (is == null) {
                String recursos = getClass().getClassLoader().getResource(".").getPath();
                return "❗ Não foi possível encontrar a explicação para o bloco: " + tipoBloco + "\nClasspath: " + recursos;
            }

            ExplicacaoDTO dto = mapper.readValue(is, ExplicacaoDTO.class);

            // 🔄 Normalização robusta: remove espaços e underscores, tudo minúsculo
            String tipoNormalizado = tipoBloco.toLowerCase().replaceAll("[ _]", "");
            String tipoJsonNormalizado = dto.getTipo().toLowerCase().replaceAll("[ _]", "");

            if (!tipoJsonNormalizado.equals(tipoNormalizado)) {
                return "❓ Nenhuma explicação disponível para o bloco: " + tipoBloco;
            }

            return dto.getExplicacao();

        } catch (Exception e) {
            return "❗ Ocorreu um erro ao carregar a explicação do bloco: " + tipoBloco + "\nErro: " + e.getMessage();
        }
    }
}
