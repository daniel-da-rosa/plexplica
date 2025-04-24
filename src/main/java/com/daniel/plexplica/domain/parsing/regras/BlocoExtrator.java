package com.daniel.plexplica.domain.parsing.regras;

import com.daniel.plexplica.domain.modelo.Bloco;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BlocoExtrator {

    // 🔍 Método para encontrar índice usando regex
    public static int encontrarIndiceRegex(String codigo, String regex){
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(codigo);

        if (matcher.find()) {
            return matcher.start();
        }
        return -1; //Não econtrou
    }

    // 🧱 Método genérico para extrair qualquer bloco
    public static Bloco extrairBloco(String codigo, String regexInicio, String regexFim, String tipoBloco){
        int inicio = encontrarIndiceRegex(codigo,regexInicio);
        if (inicio == -1) {
            throw new IllegalStateException("Bloco "+ tipoBloco + " não encontrado!");
        }

        int fim = regexFim !=null ? encontrarIndiceRegex(codigo,regexFim) : -1;
        if(fim == -1 || fim < inicio) {
            fim = codigo.length();

        }
        String trecho = codigo.substring(inicio,fim).trim();

        // 🧹 Normalização
        trecho = trecho.replaceAll("\\s+", " ");

        return new Bloco(tipoBloco,trecho);


    }
}
