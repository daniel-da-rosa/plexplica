package com.daniel.plexplica.infrastructure.antlr.util;

import com.daniel.plexplica.infrastructure.antlr.PlSqlLexer;
import com.daniel.plexplica.infrastructure.antlr.PlSqlParser;
import com.daniel.plexplica.infrastructure.antlr.visitor.SqlCompactorVisitor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class LimpezaDeSqlComParser {

    public static String compactar(String sqlOriginal) {
        PlSqlLexer lexer = new PlSqlLexer(CharStreams.fromString(sqlOriginal));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PlSqlParser parser = new PlSqlParser(tokens);

        SqlCompactorVisitor visitor = new SqlCompactorVisitor();
        return visitor.visit(parser.sql_script()); // Começa do nó principal
    }
}
