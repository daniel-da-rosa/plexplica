package com.daniel.plexplica.domain.explicacao;

import com.daniel.plexplica.domain.modelo.Bloco;

public class ExplicacaoWhere implements ExplicacaoDeBloco{
    @Override
    public boolean aplica(Bloco bloco) {
        return bloco.getTipo().equalsIgnoreCase("WHERE");
    }

    @Override
    public String explicar(Bloco bloco) {
        return "\uD83D\uDD0D Este bloco define uma condição para filtrar os resultados da consulta.";
    }
}
