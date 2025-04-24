package com.daniel.plexplica.domain.modelo;

public class Bloco {
    private String tipo;
    private String conteudo;

    public Bloco (String tipo, String conteudo){
        this.tipo = tipo;
        this.conteudo = conteudo;
    }

    public String getTipo(){
        return  this.tipo;
    }
    public String getConteudo(){
        return this.conteudo;
    }
    @Override
    public String toString(){
        return "\uD83D\uDD39 Tipo: " + tipo + "\n" +
                "\uD83D\uDD38 Conteúdo: " + conteudo;
    }
}
