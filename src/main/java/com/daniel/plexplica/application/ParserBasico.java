package com.daniel.plexplica.application;

import com.daniel.plexplica.domain.modelo.Bloco;
import com.daniel.plexplica.domain.parsing.regras.*;

import java.util.ArrayList;
import java.util.List;

public class ParserBasico {

    private final List<RegraDeParsing> regras;

    public ParserBasico(List<RegraDeParsing> regras) {
        this.regras = regras;
    }

    public List<Bloco> identificaBlocosLogicos(String codigo) {
        codigo = codigo.toUpperCase();
        List<Bloco> blocos = new ArrayList<>();

        for (RegraDeParsing regra : regras) {
            if (regra.aplica(codigo)) {
                blocos.add(regra.extrair(codigo));
            }
        }
        return blocos;
    }
}
