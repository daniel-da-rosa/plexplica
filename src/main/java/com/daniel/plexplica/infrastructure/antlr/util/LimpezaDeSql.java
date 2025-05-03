 package com.daniel.plexplica.infrastructure.antlr.util;

 import org.antlr.v4.runtime.*;
 import org.antlr.v4.runtime.misc.Interval;
 import com.daniel.plexplica.infrastructure.antlr.PlSqlLexer;


 import java.util.List;

 public class LimpezaDeSql {

     public static String gerarVersaoCompacta(String sqlOriginal) {
         CharStream input = CharStreams.fromString(sqlOriginal);
         PlSqlLexer lexer = new PlSqlLexer(input);

         CommonTokenStream tokens = new CommonTokenStream(lexer);
         tokens.fill();

         StringBuilder sqlCompactado = new StringBuilder();
         List<Token> todosTokens = tokens.getTokens();

         for (Token token : todosTokens) {
             if (token.getChannel() != Token.HIDDEN_CHANNEL) {
                 sqlCompactado.append(token.getText()).append(" ");
             }
         }

         return sqlCompactado.toString().trim();
     }
 }
