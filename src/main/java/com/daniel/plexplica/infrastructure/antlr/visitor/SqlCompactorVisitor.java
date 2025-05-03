package com.daniel.plexplica.infrastructure.antlr.visitor;

import com.daniel.plexplica.infrastructure.antlr.PlSqlParserBaseVisitor;
import org.antlr.v4.runtime.tree.RuleNode;

public class SqlCompactorVisitor extends PlSqlParserBaseVisitor<String> {

    private final StringBuilder builder = new StringBuilder();

    @Override
    public String visitChildren(RuleNode node) {
        int n = node.getChildCount();
        for (int i = 0; i < n; i++) {
            String childText = node.getChild(i).getText();
            if (!childText.isBlank()) {
                builder.append(childText).append(" ");
            }
        }
        return builder.toString().trim();
    }
}
