package com.daniel.plexplica.config;

import com.daniel.plexplica.domain.explicacao.ExplicacaoDeBloco;
import com.daniel.plexplica.domain.explicacao.ExplicacaoGenericaDeBlocos;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ExplicacaoBeans {

    @Bean
    public List<ExplicacaoDeBloco> explicacoes(){
        return List.of(
                new ExplicacaoGenericaDeBlocos("SELECT"),
                new ExplicacaoGenericaDeBlocos("FROM"),
                new ExplicacaoGenericaDeBlocos("WHERE"),
                new ExplicacaoGenericaDeBlocos("GROUP_BY"),
                new ExplicacaoGenericaDeBlocos("HAVING")

        );
    }
}
