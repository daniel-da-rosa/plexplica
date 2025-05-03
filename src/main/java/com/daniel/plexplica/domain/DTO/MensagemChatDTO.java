package com.daniel.plexplica.domain.DTO;

import java.time.LocalDateTime;

public class MensagemChatDTO {
    private String pergunta;
    private String resposta;
    private LocalDateTime timestamp;

    public MensagemChatDTO() {}

    public MensagemChatDTO(String pergunta, String resposta) {
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.timestamp = LocalDateTime.now();
    }

    public String getPergunta() { return pergunta; }
    public void setPergunta(String pergunta) { this.pergunta = pergunta; }

    public String getResposta() { return resposta; }
    public void setResposta(String resposta) { this.resposta = resposta; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
