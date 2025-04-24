# ADR 0002: Decisão Sobre Uso de ANTLR

## Status
Aceito

## Contexto
Durante o desenvolvimento inicial, foi considerada a adoção do **ANTLR** como ferramenta para parsing de PL/SQL, visto que há gramáticas existentes para essa linguagem. No entanto, dificuldades com a integração e a complexidade desnecessária para o escopo inicial fizeram repensar a estratégia.

## Decisão
- **Não utilizar ANTLR** na primeira fase do projeto.
- Continuar com um parser manual e simplificado, baseado em regex, para identificação dos blocos SQL básicos.

## Consequências
- Redução na complexidade e dependências do projeto inicial
- Parsing limitado a blocos básicos, sem suporte a sintaxes complexas ou variantes PL/SQL
- Potencial reavaliação futura para adoção de ANTLR ou outra ferramenta se o escopo exigir
