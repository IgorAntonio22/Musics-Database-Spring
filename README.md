## Technologies Used

- **Spring Boot**: Framework for creating robust Java applications.
- **Spring Data JPA**: Simplifies data access with Hibernate as the JPA provider.
- **Spring Web**: Supports building web applications with Spring MVC.
- **PostgreSQL**: Database management system used for data storage.
- **JUnit 5**: Testing framework for unit and integration tests.
- **Mockito**: Mocking framework for unit tests.

# Project Endpoints Documentation

This document provides an overview of the API endpoints exposed by the project.

## Artista Controller

### 1. POST /api/v1/artista

**Description:** Creates a new artist entry in the database.

**Request Body:**

{
"nome": "Artist Name",
"tipo": "Artist Type"
}


This endpoint allows the client to create a new artist entry by providing a JSON object with the `nome` (name) and `tipo` (type) fields. Upon successful creation, the artist details are stored in the database.

---

### 2. GET /api/v1/artista/{nome}

**Description:** Fetches details about an artist by name.

**Path Parameter:**
- `nome`: Name of the artist to retrieve.

This endpoint retrieves details about a specific artist from the database based on their `nome` (name). It returns information such as the artist's name, type, and other related details if available.

---

## Musica Controller

### 1. POST /api/v1/musica

**Description:** Creates a new song entry in the database.

**Request Body:**

{
    "nome": "Song Name",
    "artista": {
        "nome": "Artist Name",
        "tipo": "solo"
    }
}

This endpoint allows the client to create a new song entry by providing a JSON object with the `nome` (song name) and `artista.nome` (artist name) fields. The song details, including the associated artist, are stored in the database upon successful creation.

---

### 2. GET /api/v1/musica

**Description:** Fetches all songs stored in the database.

This endpoint retrieves a list of all songs currently stored in the database. It returns details about each song, including its name and the associated artist's information.

---

### 3. GET /api/v1/musica/{nomeDoArtista}

**Description:** Fetches songs by artist name.

**Path Parameter:**
- `nomeDoArtista`: Name of the artist to filter songs.

This endpoint retrieves songs from the database that are associated with a specific artist, identified by their `nome` (name). It returns a list of songs that match the criteria, including details about each song and its associated artist.

---

### Explanation

- **Artista Controller**:
  - **POST /api/v1/artista**: Endpoint for creating a new artist entry. Requires a JSON object with `nome` (name) and `tipo` (type) fields.
  - **GET /api/v1/artista/{nome}**: Endpoint to fetch details about an artist by their name.

- **Musica Controller**:
  - **POST /api/v1/musica**: Endpoint for creating a new song entry. Requires a JSON object with `nome` (song name) and `artista.nome` (artist name) and `artista.tipo` (artist type) fields.
  - **GET /api/v1/musica**: Endpoint to fetch all songs stored in the database.
  - **GET /api/v1/musica/{nomeDoArtista}**: Endpoint to fetch songs associated with a specific artist name.
