# PL-Explica

O **PL-Explica** é uma ferramenta desenvolvida para analisar e explicar blocos de código SQL, especialmente **PL/SQL**, de forma clara e didática, facilitando o entendimento de estruturas complexas mesmo para iniciantes. 

Este projeto é a **vanguarda prática da metodologia SCCPE-D³**, que norteia todo o desenvolvimento, garantindo qualidade, clareza e propósito em cada linha de código.

## ✨ Metodologia SCCPE-D³

- **S** - SOLID
- **C** - Clean Code
- **C** - Clareza com Propósito
- **P** - Profissionalismo de Elite
- **E** - Engenharia de Domínio (Domain-Driven Design)
- **D³** - Três Dimensões Fundamentais:
  - Decisões Conscientes
  - Documentação Útil
  - Design Sustentável

**Manifesto**:  
_"A metodologia SCCPE-D³ transforma o código em comunicação clara, o sistema em organismo vivo, e o desenvolvedor em estrategista do próprio legado."_

## 🚀 Funcionalidades

- Identificação de blocos SQL (SELECT, FROM, WHERE, GROUP BY, etc.).
- Explicação de cada bloco de forma simples e didática.
- Base de explicações em **JSON** para fácil manutenção e expansão.

## 🛠️ Tecnologias

- **Java 17**
- **Spring Boot 3.4.4**
- **Maven**
- **Jackson** (para leitura de JSON)
- **Lombok** (para simplificar DTOs)

## 📁 Estrutura do Projeto
plexplica/
├── src/
│   └── main/
│       ├── java/com/daniel/plexplica/
│       │   ├── controller/       # Camada de exposição (REST APIs)
│       │   ├── domain/           # Camada de domínio
│       │   │   ├── explicacao/   # Estratégias de explicação dos blocos SQL
│       │   │   ├── modelo/       # Modelos e DTOs
│       │   │   └── parsing/      # Regras de parsing (análise de código)
│       │   └── service/          # Serviços (orquestram regras e explicações)
│       └── resources/
│           └── explicacoes/      # Arquivos JSON com explicações de cada bloco
└── docs/
    └── adr/                      # Architecture Decision Records (ADRs)
