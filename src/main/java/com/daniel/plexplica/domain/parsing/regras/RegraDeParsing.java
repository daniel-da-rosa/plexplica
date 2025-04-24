package com.daniel.plexplica.domain.parsing.regras;

import com.daniel.plexplica.domain.modelo.Bloco;

public interface RegraDeParsing {
    boolean aplica(String codigo);
    Bloco extrair(String codigo);
}
