# Pagamento Microservice

O serviço `pagamento-microservice` é responsável por realizar o pagamento de empréstimos. Este serviço consome mensagens de um tópico Kafka para processar pagamentos e atualizar o status de empréstimos no banco de dados.

## Link para analisar o system design
https://excalidraw.com/#json=JzVtjeFzkjUte7LjAIjY3,9s98r-DwyxZjnMMQuuP2Ew

## Pré-requisitos

- **Java 17+**
- **Maven**
- **Docker e Docker Compose**
- **Kafka** (instalado via Docker Compose)

## Como Executar a Aplicação

Siga os passos abaixo para configurar e rodar a aplicação:

### 1. Configurar e Executar os Serviços com Docker Compose

Primeiro, vamos configurar os serviços necessários (PostgreSQL, Kafka, etc.) usando o Docker Compose.

1. Seguir todos os passos do serviço de emprestimos
2. mvn clean install
3. mvn spring-boot:run

