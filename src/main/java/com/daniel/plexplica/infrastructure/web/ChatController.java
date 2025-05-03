package com.daniel.plexplica.infrastructure.web;

import com.daniel.plexplica.domain.DTO.MensagemChatDTO;
import com.daniel.plexplica.domain.DTO.PerguntaChatDTO;
import com.daniel.plexplica.infrastructure.web.llm.LlmClient;
import com.daniel.plexplica.infrastructure.web.llm.PromptBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final LlmClient llmClient;
    private final PromptBuilder promptBuilder;

    public ChatController(LlmClient llmClient, PromptBuilder promptBuilder) {
        this.llmClient = llmClient;
        this.promptBuilder = promptBuilder;
    }

    @PostMapping("/perguntar")
    public MensagemChatDTO perguntar(@RequestBody PerguntaChatDTO dto) {
        String prompt = promptBuilder.construirPromptComChat(
                dto.getExplicacaoOriginal(),
                dto.getHistorico(),
                dto.getPergunta()
        );

        String resposta = llmClient.gerarRespostaSimples(prompt, dto.getModelo(), 0.7);

        return new MensagemChatDTO(dto.getPergunta(), resposta);
    }
}
