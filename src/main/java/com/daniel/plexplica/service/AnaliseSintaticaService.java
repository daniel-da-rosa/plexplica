//package com.daniel.plexplica.service;
//
//
//import com.daniel.plexplica.domain.DTO.EstruturaSqlDTO;
//import com.daniel.plexplica.infrastructure.antlr.PlSqlLexer;
//import com.daniel.plexplica.infrastructure.antlr.PlSqlParser;
//import org.antlr.v4.runtime.*;
//import org.antlr.v4.runtime.tree.ParseTree;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AnaliseSintaticaService {
//
//    public EstruturaSqlDTO analisar(String sql) {
//        try {
//            CharStream input = CharStreams.fromString(sql);
//            PlSqlLexer lexer = new PlSqlLexer(input);
//            CommonTokenStream tokens = new CommonTokenStream(lexer);
//            PlSqlParser parser = new PlSqlParser(tokens);
//
//            ParseTree arvore = parser.sql_script(); // Entrada principal
//
//            // Aqui você pode navegar pela árvore (com visitor ou listener depois)
//            // Por ora, vamos fazer um chute simples só com texto:
//            String tipo = identificarTipo(sql);
//            boolean temJoin = sql.toUpperCase().contains("JOIN");
//            boolean temCase = sql.toUpperCase().contains("CASE");
//
//            return new EstruturaSqlDTO(tipo, temJoin, temCase);
//
//        } catch (Exception e) {
//            throw new RuntimeException("Erro ao analisar sintaticamente o SQL", e);
//        }
//    }
//
//    private String identificarTipo(String sql) {
//        String upper = sql.trim().toUpperCase();
//        if (upper.startsWith("SELECT")) return "SELECT";
//        if (upper.startsWith("INSERT")) return "INSERT";
//        if (upper.startsWith("UPDATE")) return "UPDATE";
//        if (upper.startsWith("DELETE")) return "DELETE";
//        return "DESCONHECIDO";
//    }
//}
