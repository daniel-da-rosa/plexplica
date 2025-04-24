package com.daniel.plexplica.service;

import com.daniel.plexplica.application.IdentificadorDeBloco;
import com.daniel.plexplica.domain.explicacao.ExplicacaoDeBloco;
import com.daniel.plexplica.domain.modelo.Bloco;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExplicacaoService {

    private final List<ExplicacaoDeBloco> explicacoes;
    private final IdentificadorDeBloco identificador;

    public ExplicacaoService (List<ExplicacaoDeBloco> explicacoes, IdentificadorDeBloco identificador){
        this.explicacoes = explicacoes;
        this.identificador = identificador;

    }

    public String explicacaoCodigo(String codigoSql){
        List<Bloco> blocos = identificador.identificar(codigoSql);
        System.out.println("Blocos identificados "+blocos.size());

        StringBuilder resultado = new StringBuilder();

        for (Bloco bloco : blocos) {
            System.out.println("🔍 Bloco encontrado: " + bloco.getTipo() + " - " + bloco.getConteudo());
            for (ExplicacaoDeBloco explicacao : explicacoes) {
                boolean aplica = explicacao.aplica(bloco);
                System.out.println("Tentando aplicar explicacao para: " + bloco.getTipo() + " - Aplica? " + aplica);
                if (aplica) {
                    String explicacaoTexto = explicacao.explicar(bloco);
                    System.out.println("Explicação gerada: " + explicacaoTexto);
                    resultado.append(bloco.getConteudo()+" - "+explicacaoTexto).append("\n\n");
                }
            }
        }

        return resultado.toString();
    }
}
