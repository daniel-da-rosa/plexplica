package com.daniel.plexplica.domain.parsing.regras;

import com.daniel.plexplica.domain.modelo.Bloco;

public class RegraSelect implements RegraDeParsing {

    @Override
    public boolean aplica(String codigo){
        return codigo.contains("SELECT") && codigo.contains("FROM");
    }

    @Override
    public Bloco extrair(String codigo){
        return BlocoExtrator.extrairBloco(
                codigo,
                "\\bSELECT\\b",
                "\\bFROM\\b",
                "SELECT"
        );
    }
}
