package com.daniel.plexplica.domain.parsing.regras;

import com.daniel.plexplica.domain.modelo.Bloco;

public class RegraHaving implements RegraDeParsing{
    @Override
    public boolean aplica(String codigo) {
        return BlocoExtrator.encontrarIndiceRegex(codigo,"\\bHAVING\\b") !=-1;
    }

    @Override
    public Bloco extrair(String codigo) {
        return BlocoExtrator.extrairBloco(
                codigo,
                "\\bHAVING\\b",
                "\\bORDER\\s+BY\\b",
                "HAVING"
        );
    }
}
