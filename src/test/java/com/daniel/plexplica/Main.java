package com.daniel.plexplica.infrastructure;

import com.daniel.plexplica.domain.modelo.Bloco;

public class Main {
    public static void main(String[] args) {
        Bloco bloco = new Bloco("SELECT", "SELECT nome FROM clientes");
        System.out.println(bloco);
    }
}
