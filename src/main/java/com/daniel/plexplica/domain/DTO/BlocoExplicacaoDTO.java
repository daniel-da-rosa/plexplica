package com.daniel.plexplica.domain.DTO;

import java.util.List;
import lombok.Data;

@Data
public class BlocoExplicacaoDTO {
    private long id;
    private String sql;
    private MetadadosDTO metadados;
    private ExplicacaoDTO explicacao;
    private List<InteracaoDTO> historicoDeInteracoes;

}
