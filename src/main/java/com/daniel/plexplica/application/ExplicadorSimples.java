package com.daniel.plexplica.application;

import com.daniel.plexplica.domain.explicacao.ExplicacaoDeBloco;
import com.daniel.plexplica.domain.modelo.Bloco;

import java.util.List;

public class ExplicadorSimples {
    private final List<ExplicacaoDeBloco> explicacoes;

    public ExplicadorSimples(List<ExplicacaoDeBloco> explicacoes) {
        this.explicacoes = explicacoes;
    }

    public String explicaBLocoSql(Bloco bloco) {
        return explicacoes.stream()
                .filter(exp -> exp.aplica(bloco))
                .findFirst()
                .map(exp -> exp.explicar(bloco))
                .orElse("ℹ️ Tipo de bloco não reconhecido. Nenhuma explicação disponível.");
    }
}
