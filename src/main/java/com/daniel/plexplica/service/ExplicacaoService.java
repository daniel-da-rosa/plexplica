package com.daniel.plexplica.service;

import com.daniel.plexplica.application.IdentificadorDeBloco;
import com.daniel.plexplica.domain.DTO.*;
import com.daniel.plexplica.domain.modelo.Bloco;
import com.daniel.plexplica.domain.modelo.Metadados;
import com.daniel.plexplica.infrastructure.web.llm.LlmClient;
import com.daniel.plexplica.infrastructure.web.llm.PromptBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExplicacaoService {

    private final IdentificadorDeBloco identificador;
    private final LlmClient llmClient;
    private final PromptBuilder promptBuilder;


    public BlocoExplicacaoDTO explicaBloco(ExplicacaoRequestDTO request) {

        //identifica os blocos sql usados com o parser antlr
        List<Bloco> blocos = identificador.identificar(request.getSql());
        Metadados metadados = converteMetadados(request.getMetadados());

        //monta o prompt com o metados + blocos
        String prompt = promptBuilder.construirPrompt(request.getSql(), metadados);

        //Chama a llm para gerar a explicacao
        ExplicacaoDTO explicacao = llmClient.gerarExplicacao(prompt, metadados, request.getModeloLLM(), request.getHeat());


        return construirResposta(request, explicacao);

    }

    private Metadados converteMetadados(MetadadosDTO dto) {

        Metadados metadados = new Metadados();
        metadados.setLocalizacao(dto.getLocalizacao());
        metadados.setObjetivo(dto.getObjetivo());
        metadados.setMemo(dto.getMemo());
        return metadados;
    }

    private BlocoExplicacaoDTO construirResposta(ExplicacaoRequestDTO request, ExplicacaoDTO explicacao) {

        BlocoExplicacaoDTO resposta = new BlocoExplicacaoDTO();
        resposta.setSql(request.getSql());
        resposta.setMetadados(request.getMetadados());
        resposta.setExplicacao(explicacao);
        resposta.setHistoricoDeInteracoes(List.of());

        return resposta;

    }
}
