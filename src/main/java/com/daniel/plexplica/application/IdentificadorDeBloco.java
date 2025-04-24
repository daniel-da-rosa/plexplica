package com.daniel.plexplica.application;

import com.daniel.plexplica.domain.modelo.Bloco;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IdentificadorDeBloco {
    public List<Bloco> identificar(String codigoSql){
        String codigo = codigoSql.toUpperCase();
        List<Bloco> blocos = new ArrayList<>();

        int inicio = 0;
        inicio = extrairBloco(blocos, "SELECT", "FROM", codigo, inicio);
        inicio = extrairBloco(blocos, "FROM", "WHERE", codigo, inicio);
        inicio = extrairBloco(blocos, "WHERE", "GROUP BY", codigo, inicio);
        inicio = extrairBloco(blocos, "GROUP BY", "HAVING", codigo, inicio);
        extrairBloco(blocos, "HAVING", null, codigo, inicio);

        return blocos;
    }

    private int extrairBloco(List<Bloco> blocos, String inicioToken,
                             String fimToken, String codigoSql,int inicioBusca){
        int inicio = codigoSql.indexOf(inicioToken,inicioBusca);
        if (inicio == -1){
            return inicioBusca;
        }

        int fim = fimToken != null ? codigoSql.indexOf(fimToken, inicio + inicioToken.length()) : codigoSql.length();
        if(fim ==-1){
            fim = codigoSql.length();
        }
        String trecho = codigoSql.substring(inicio,fim).trim();
        blocos.add(new Bloco(inicioToken.replace(" ","_"),trecho));
        return fim;
    }
}
