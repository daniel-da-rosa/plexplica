package com.daniel.plexplica.domain.DTO;

import lombok.Data;

@Data
public class ExplicacaoRequestDTO {
    private String sql;
    private MetadadosDTO metadados;
    private String modeloLLM;
    private Double heat;
}
