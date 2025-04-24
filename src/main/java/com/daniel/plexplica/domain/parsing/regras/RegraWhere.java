package com.daniel.plexplica.domain.parsing.regras;

import com.daniel.plexplica.domain.modelo.Bloco;

public class RegraWhere implements RegraDeParsing{

    @Override
    public boolean aplica(String codigo) {
        return codigo.contains("WHERE");
    }

    @Override
    public Bloco extrair(String codigo) {
        return BlocoExtrator.extrairBloco(
                codigo,
                "\\bWHERE\\b",           // regex do início
                "\\bGROUP\\s+BY\\b",     // regex do fim (ou null)
                "WHERE"                  // tipo do bloco
                );
    }
}
