package com.daniel.plexplica.domain.explicacao;

import com.daniel.plexplica.domain.modelo.*;

public class ExplicaoHaving implements ExplicacaoDeBloco {
    @Override
    public boolean aplica(Bloco bloco) {
        return bloco.getTipo().equalsIgnoreCase("HAVING");
    }

    @Override
    public String explicar(Bloco bloco) {
        return "🔎Este bloco define condições para os dados **agrupados**, filtrando os resultados após o uso do GROUP BY.";
    }
}