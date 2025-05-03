package com.daniel.plexplica.domain.DTO;
import com.daniel.plexplica.domain.modelo.Metadados;

import java.util.List;
import lombok.Data;

@Data
public class BlocoExplicacaoDTO {
    private long id;
    private String sql;
    private Metadados metadados;
    private ExplicacaoDTO explicacao;

}
