# ADR 0004 - Substituição das classes de explicação por DTOs e JSON

## Status
Aceita

## Contexto
Inicialmente, o projeto PL-Explica utilizava classes específicas para cada explicação dos blocos SQL, com métodos e lógicas encapsuladas nessas classes. Embora funcionais, essas estruturas dificultavam a escalabilidade, geravam redundância e criavam um forte acoplamento entre o parser e o formato da explicação.

Com a evolução do projeto e a adoção de Spring Boot, surgiu a necessidade de tornar as explicações mais **flexíveis, desacopladas** e facilmente integráveis com APIs REST e outros sistemas, seguindo os princípios da metodologia **SCCPE-D³**.

## Decisão
Substituímos as antigas classes de explicação por **DTOs (Data Transfer Objects)**, responsáveis por estruturar os dados das explicações de forma clara, padronizada e agnóstica ao formato de saída. As explicações passaram a ser geradas em **JSON**, facilitando a integração com front-ends, APIs, ou qualquer outro consumidor.

Essa abordagem reforça a clareza, mantém o sistema extensível e alinha-se com o propósito de oferecer explicações legíveis tanto para humanos quanto para máquinas.

## Consequências
- **Positivas:**
    - Maior desacoplamento entre o parser e o formato de apresentação das explicações.
    - Facilidade de integração com APIs REST.
    - Estrutura mais enxuta, seguindo os princípios de **Clareza com Propósito**.
    - Adoção mais fluida de boas práticas como **DTOs** e serialização **JSON**.

- **Negativas:**
    - Demanda um controle maior sobre a formatação e estruturação dos dados em diferentes camadas.
    - Eliminação de lógica encapsulada nas antigas classes de explicação, exigindo atenção para manter a consistência nos DTOs.

## Alternativas consideradas
- **Manter as classes de explicação:**  
  Rejeitada por gerar acoplamento excessivo, dificultar integração com APIs e limitar a evolução do formato de saída.

- **Utilizar templates estáticos para gerar explicações:**  
  Rejeitada por perder flexibilidade no formato dos dados e dificultar personalização ou evolução do conteúdo gerado.

## Justificativa alinhada ao SCCPE-D³
Essa decisão reforça os pilares da metodologia **SCCPE-D³**, priorizando **Clean Code**, **Clareza com Propósito** e **Profissionalismo de Elite**. Optamos por estruturas que favorecem a **compreensão, flexibilidade e integração**, garantindo que o sistema evolua com propósito e mantenha-se robusto diante de novas necessidades.
