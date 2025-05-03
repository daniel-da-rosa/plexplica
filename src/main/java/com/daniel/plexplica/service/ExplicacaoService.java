package com.daniel.plexplica.service;

import com.daniel.plexplica.domain.DTO.BlocoExplicacaoDTO;
import com.daniel.plexplica.domain.DTO.ExplicacaoDTO;
import com.daniel.plexplica.domain.modelo.Metadados;
import com.daniel.plexplica.infrastructure.antlr.util.LimpezaDeSqlComParser;
import com.daniel.plexplica.infrastructure.web.llm.LlmClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExplicacaoService {

    private final LlmClient llmClient;

    public ExplicacaoService(LlmClient llmClient) {
        this.llmClient = llmClient;
    }

    public BlocoExplicacaoDTO explicaBloco(String sql) {
        String modelo = null;
        Double temperatura = null;

        Metadados metadados = new Metadados();
        String sqlCompactado = LimpezaDeSqlComParser.compactar(sql);

        ExplicacaoDTO explicacao = llmClient.gerarExplicacao(sqlCompactado, metadados, modelo, temperatura);

        BlocoExplicacaoDTO bloco = new BlocoExplicacaoDTO();
        bloco.setSql(sqlCompactado);
        bloco.setMetadados(metadados);
        bloco.setExplicacao(explicacao);
        return bloco;
    }
}
