# ADR 0003: Migração para Spring Boot

## Status
Aceito

## Contexto
Com o avanço do projeto, surgiu a necessidade de expor a funcionalidade de explicação de blocos SQL via uma API HTTP para facilitar integrações futuras, como frontends ou outras ferramentas. Para isso, decidiu-se migrar o projeto para o **Spring Boot**, aproveitando sua robustez e suporte a REST APIs.

## Decisão
- Migrar o projeto para o ecossistema **Spring Boot**
- Usar **Maven** como gerenciador de dependências
- Manter os princípios da metodologia **SCCPE-D³**, garantindo clareza, modularidade e propósito em todas as camadas
- Organização em pacotes: `controller`, `service`, `domain` (modelo, parsing, explicacao), `config`

## Consequências
- Facilita a exposição de endpoints HTTP para o PL-Explica
- Permite futuras integrações com banco de dados (ex: MongoDB)
- Introduz complexidade adicional na configuração e build do projeto
- Aumenta a escalabilidade e modularidade do sistema
