package com.daniel.plexplica.domain.parsing.regras;

import com.daniel.plexplica.domain.modelo.Bloco;

public class RegraFrom implements RegraDeParsing{

    @Override
    public boolean aplica(String codigo){
        return codigo.contains("FROM");
    }

    @Override
    public Bloco extrair(String codigo){
        return BlocoExtrator.extrairBloco(
                codigo,
                "\\bFROM\\b",         // regex do início
                "\\s+WHERE\\b",
                "FROM"
                );
    }
}
