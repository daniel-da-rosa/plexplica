package com.daniel.plexplica.infrastructure.antlr.util;

import com.daniel.plexplica.infrastructure.antlr.PlSqlParser;
import com.daniel.plexplica.infrastructure.antlr.PlSqlParserBaseVisitor;

/**
 * Visitor que gera uma versão compactada (sem quebras, espaçamentos desnecessários e sem comentários)
 * a partir da árvore sintática do comando SQL/PLSQL.
 */
public class SqlCompactorVisitor extends PlSqlParserBaseVisitor<StringBuilder> {

    private final StringBuilder builder = new StringBuilder();

    @Override
    public StringBuilder visitTerminal(org.antlr.v4.runtime.tree.TerminalNode node) {
        String texto = node.getText();

        // Ignorar tokens ocultos (comentários, espaços, etc.)
        if (!texto.isBlank()) {
            builder.append(texto).append(" ");
        }
        return builder;
    }

    @Override
    protected StringBuilder defaultResult() {
        return builder;
    }

    @Override
    protected StringBuilder aggregateResult(StringBuilder aggregate, StringBuilder nextResult) {
        return builder;
    }

    public String getSqlCompactado() {
        return builder.toString().trim();
    }
}
