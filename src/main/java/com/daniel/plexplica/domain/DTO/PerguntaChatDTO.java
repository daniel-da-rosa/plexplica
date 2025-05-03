package com.daniel.plexplica.domain.DTO;

import java.util.List;

public class PerguntaChatDTO {
    private String explicacaoOriginal;
    private List<MensagemChatDTO> historico;
    private String pergunta;
    private String modelo;
    private String memo;

    public String getExplicacaoOriginal() { return explicacaoOriginal; }
    public void setExplicacaoOriginal(String explicacaoOriginal) { this.explicacaoOriginal = explicacaoOriginal; }

    public List<MensagemChatDTO> getHistorico() { return historico; }
    public void setHistorico(List<MensagemChatDTO> historico) { this.historico = historico; }

    public String getPergunta() { return pergunta; }
    public void setPergunta(String pergunta) { this.pergunta = pergunta; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getMemo() { return memo; }
    public void setMemo(String memo) { this.memo = memo; }
}
