package com.daniel.plexplica.domain.DTO;

import java.util.List;

import lombok.Data;

@Data
public class ExplicacaoDTO {
    private String explicacao;
    private List<String> alertas;
    private List<String> recomendacoes;
    private List<String> tags;
    private String nivel;
    private String modeloLLM;


}
