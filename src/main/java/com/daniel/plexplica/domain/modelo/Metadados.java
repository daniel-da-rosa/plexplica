package com.daniel.plexplica.domain.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Metadados {
    private String localizacao;
    private String objetivo;
    private String memo;
}
