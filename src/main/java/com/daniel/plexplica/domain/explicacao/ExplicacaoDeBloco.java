package com.daniel.plexplica.domain.explicacao;

import com.daniel.plexplica.domain.modelo.Bloco;

public interface ExplicacaoDeBloco {
    boolean aplica(Bloco bloco);
    String explicar(Bloco bloco);
}
