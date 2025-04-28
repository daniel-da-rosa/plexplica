package com.daniel.plexplica.domain.DTO;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class InteracaoDTO {
    private String pergunta;
    private String resposta;
    private LocalDateTime data;
}
