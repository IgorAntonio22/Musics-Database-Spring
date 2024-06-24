# Tecnologias Utilizadas

- **Spring Boot**: Framework para criar aplicações Java robustas.
- **Spring Data JPA**: Simplifica o acesso aos dados com o Hibernate como provedor JPA.
- **Spring Web**: Suporta a construção de aplicações web com Spring MVC.
- **PostgreSQL**: Sistema de gerenciamento de banco de dados usado para armazenamento de dados.
- **JUnit 5**: Framework de testes para testes unitários e de integração.
- **Mockito**: Framework de mock para testes unitários.


# Documentação de Endpoints do Projeto

Este documento fornece uma visão geral dos endpoints da API expostos pelo projeto.

## Controlador de Artista

### 1. POST /api/v1/artista

**Descrição:** Cria uma nova entrada de artista no banco de dados.

**Corpo da Requisição:**

{
    "nome": "Nome do Artista",
    "tipo": "Tipo do Artista"
}

Este endpoint permite que o cliente crie uma nova entrada de artista fornecendo um objeto JSON com os campos `nome` (nome) e `tipo` (tipo). Após a criação bem-sucedida, os detalhes do artista são armazenados no banco de dados.

---

### 2. GET /api/v1/artista/{nome}

**Descrição:** Recupera detalhes sobre um artista pelo nome.

**Parâmetro de Caminho:**
- `nome`: Nome do artista a ser recuperado.

Este endpoint recupera detalhes sobre um artista específico do banco de dados com base no seu `nome`. Ele retorna informações como o nome do artista, tipo e outros detalhes relacionados, se disponíveis.

---

## Controlador de Música

### 1. POST /api/v1/musica

**Descrição:** Cria uma nova entrada de música no banco de dados.

**Corpo da Requisição:**

{
    "nome": "Nome da Música",
    "artista": {
        "nome": "Nome do Artista",
        "tipo": "solo"
    }
}

Este endpoint permite que o cliente crie uma nova entrada de música fornecendo um objeto JSON com os campos `nome` (nome da música) e `artista.nome` (nome do artista). Os detalhes da música, incluindo o artista associado, são armazenados no banco de dados após a criação bem-sucedida.

---

### 2. GET /api/v1/musica

**Descrição:** Recupera todas as músicas armazenadas no banco de dados.

Este endpoint recupera uma lista de todas as músicas atualmente armazenadas no banco de dados. Ele retorna detalhes sobre cada música, incluindo seu nome e informações sobre o artista associado.

---

### 3. GET /api/v1/musica/{nomeDoArtista}

**Descrição:** Recupera músicas pelo nome do artista.

**Parâmetro de Caminho:**
- `nomeDoArtista`: Nome do artista para filtrar as músicas.

Este endpoint recupera músicas do banco de dados que estão associadas a um artista específico, identificado pelo seu `nome`. Ele retorna uma lista de músicas que correspondem ao critério, incluindo detalhes sobre cada música e seu artista associado.

---

### Explicação

- **Controlador de Artista**:
  - **POST /api/v1/artista**: Endpoint para criar uma nova entrada de artista. Requer um objeto JSON com os campos `nome` (nome) e `tipo` (tipo).
  - **GET /api/v1/artista/{nome}**: Endpoint para recuperar detalhes sobre um artista pelo nome.

- **Controlador de Música**:
  - **POST /api/v1/musica**: Endpoint para criar uma nova entrada de música. Requer um objeto JSON com os campos `nome` (nome da música) e `artista.nome` (nome do artista).
  - **GET /api/v1/musica**: Endpoint para recuperar todas as músicas armazenadas no banco de dados.
  - **GET /api/v1/musica/{nomeDoArtista}**: Endpoint para recuperar músicas associadas a um nome específico de artista.
