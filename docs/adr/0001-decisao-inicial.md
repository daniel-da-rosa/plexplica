# ADR 0001: Decisão Inicial do Projeto

## Status
Aceito

## Contexto
O projeto PL-Explica foi iniciado com o propósito de criar uma ferramenta capaz de identificar blocos de código SQL (inicialmente focado em PL/SQL) e fornecer explicações claras para cada bloco. A linguagem escolhida foi **Java**, utilizando uma abordagem simples, sem frameworks ou dependências externas, para priorizar o controle e aprendizado sobre o fluxo do projeto.

A metodologia **SCCPE-D³** foi adotada desde o início para guiar todas as decisões técnicas.

## Decisão
- Linguagem principal: **Java**
- Estrutura inicial: Java puro, sem frameworks
- Metodologia: **SCCPE-D³** (SOLID, Clean Code, Clareza com Propósito, Profissionalismo de Elite, Domain-Driven Design)
- Inicialmente focado em blocos básicos SQL: `SELECT`, `FROM`, `WHERE`

## Consequências
- Controle total sobre o fluxo de parsing e explicação
- Maior tempo de implementação para recursos mais complexos (ex: parsing robusto)
- Favorece o aprendizado profundo da stack envolvida
