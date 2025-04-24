package com.daniel.plexplica.domain.explicacao;

import com.daniel.plexplica.domain.modelo.Bloco;

public class ExplicacaoGroupBy implements ExplicacaoDeBloco{
    @Override
    public boolean aplica(Bloco bloco) {
        return bloco.getTipo().equalsIgnoreCase("GROUP BY");
    }

    @Override
    public String explicar(Bloco bloco) {
        return "\uD83D\uDDC2\uFE0F Este bloco define os agrupadores da consulta de dados.\n";
    }
}
