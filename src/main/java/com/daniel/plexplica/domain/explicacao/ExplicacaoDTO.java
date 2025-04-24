package com.daniel.plexplica.domain.explicacao;

public class ExplicacaoDTO {
    private String tipo;
    private String descricao;

    public String getTipo() {
        return  tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setTipo(){
        this.tipo = tipo;
    }

    public void setDescricao(){
        this.descricao = descricao;
    }
}

