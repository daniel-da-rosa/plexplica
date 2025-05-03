package com.daniel.plexplica.infrastructure.web.llm;

import com.daniel.plexplica.domain.DTO.ExplicacaoDTO;
import com.daniel.plexplica.domain.modelo.Metadados;

public interface LlmClient {
    ExplicacaoDTO gerarExplicacao(String sql, Metadados metadados, String modeloLLM, Double heat);

    String gerarRespostaSimples(String prompt, String modeloLLM, Double temperatura); // novo método
}
