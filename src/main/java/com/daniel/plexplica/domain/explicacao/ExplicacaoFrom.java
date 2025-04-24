package com.daniel.plexplica.domain.explicacao;

import com.daniel.plexplica.domain.modelo.Bloco;

public class ExplicacaoFrom implements ExplicacaoDeBloco {

    @Override
    public boolean aplica(Bloco bloco){
        return bloco.getTipo().equalsIgnoreCase("FROM");
    }

    @Override
    public String explicar(Bloco bloco){
        return  "📦 Este bloco informa a origem dos dados da consulta, ou seja, de qual tabela ou conjunto de tabelas os dados serão extraídos.";

    }


}
