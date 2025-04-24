package com.daniel.plexplica.domain.explicacao;

import com.daniel.plexplica.domain.modelo.Bloco;

public class ExplicacaoSelect implements ExplicacaoDeBloco{

    @Override
    public boolean aplica(Bloco bloco){
        return bloco.getTipo().equalsIgnoreCase("SELECT");

    }

    @Override
    public String explicar(Bloco bloco){
        return "🧠 Este bloco realiza uma seleção de colunas no banco de dados.";

    }

}
