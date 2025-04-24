package com.daniel.plexplica.service;

import com.daniel.plexplica.domain.explicacao.ExplicacaoDeBloco;
import com.daniel.plexplica.domain.modelo.Bloco;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExplicacaoService {

    private final List<ExplicacaoDeBloco> explicacoes;

    public ExplicacaoService (List<ExplicacaoDeBloco> explicacoes){
        this.explicacoes = explicacoes;
    }

    public String explicarBloco(Bloco bloco){
        return explicacoes.stream()
                .filter(exp ->exp.aplica(bloco))
                .findFirst()
                .map(exp -> exp.explicar(bloco))
                .orElse("❓ Nenhuma explicação disponível para o bloco: " + bloco.getTipo());
    }
}
