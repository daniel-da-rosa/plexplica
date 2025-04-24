package com.daniel.plexplica.domain.parsing.regras;

import com.daniel.plexplica.domain.modelo.Bloco;

public class RegraOrderBy implements RegraDeParsing{
    @Override
    public boolean aplica(String codigo) {
        return BlocoExtrator.encontrarIndiceRegex(codigo,"\\bORDER\\s+BY\\b") !=-1;
    }

    @Override
    public Bloco extrair(String codigo) {
        return BlocoExtrator.extrairBloco(
                codigo,
                "\\bORDER\\s+BY\\b",
                "\\bHAVING\\b",
                "ORDER BY"
        );
    }
}
