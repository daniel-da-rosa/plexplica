package com.daniel.plexplica.domain.DTO;

import lombok.Data;

@Data
public class ExplicacaoDTO {
    private String tipo;
    private String explicacao;
    private String[] tags;
    private String nivel;
    private String autor;
    private int versao;


}
