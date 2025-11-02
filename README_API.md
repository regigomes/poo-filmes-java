# API REST - Catálogo de Filmes

API REST desenvolvida com Spring Boot para gerenciamento de um catálogo de filmes.

## 🚀 Tecnologias

- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Data JPA**
- **H2 Database** (banco em memória)
- **Maven**
- **Lombok**

## 📋 Funcionalidades

A API implementa um CRUD completo para o cadastro de filmes com os seguintes endpoints:

### Endpoints - Filmes

| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/filmes` | Retorna todos os filmes cadastrados |
| GET | `/filmes/{id}` | Retorna um filme específico por ID |
| POST | `/filmes` | Cria um novo filme |
| PUT | `/filmes/{id}` | Atualiza completamente um filme |
| PATCH | `/filmes/{id}` | Atualiza parcialmente um filme |
| DELETE | `/filmes/{id}` | Deleta um filme |

## 🔧 Como Executar

### Pré-requisitos

- Java 17 ou superior
- Maven 3.6 ou superior

### Passos

1. **Clone o repositório ou navegue até a pasta do projeto**

2. **Compile o projeto com Maven:**
```bash
mvn clean install
```

3. **Execute a aplicação:**
```bash
mvn spring-boot:run
```

4. **A aplicação estará disponível em:** `http://localhost:8080`

## 💾 Banco de Dados H2

O projeto utiliza o banco de dados H2 em memória. Para acessar o console do H2:

- **URL:** `http://localhost:8080/h2-console`
- **JDBC URL:** `jdbc:h2:mem:catalogodb`
- **Username:** `sa`
- **Password:** (deixe em branco)

## 📝 Exemplos de Uso

### 1. Criar um novo filme (POST)

```bash
curl -X POST http://localhost:8080/filmes \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "O Senhor dos Anéis",
    "dataLancamento": "2001-12-19",
    "orcamento": 93000000.00,
    "descricao": "Uma jornada épica pela Terra Média"
  }'
```

### 2. Listar todos os filmes (GET)

```bash
curl http://localhost:8080/filmes
```

### 3. Buscar filme por ID (GET)

```bash
curl http://localhost:8080/filmes/1
```

### 4. Atualizar filme completo (PUT)

```bash
curl -X PUT http://localhost:8080/filmes/1 \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "O Senhor dos Anéis: A Sociedade do Anel",
    "dataLancamento": "2001-12-19",
    "orcamento": 93000000.00,
    "descricao": "Primeira parte da trilogia"
  }'
```

### 5. Atualizar filme parcialmente (PATCH)

```bash
curl -X PATCH http://localhost:8080/filmes/1 \
  -H "Content-Type: application/json" \
  -d '{
    "orcamento": 95000000.00
  }'
```

### 6. Deletar filme (DELETE)

```bash
curl -X DELETE http://localhost:8080/filmes/1
```

## 📦 Estrutura do Projeto

```
src/main/java/com/catalogo/filmes/
├── controller/          # Controllers REST
│   └── FilmeController.java
├── dto/                 # Data Transfer Objects
│   └── FilmeDTO.java
├── exception/           # Tratamento de exceções
│   ├── GlobalExceptionHandler.java
│   └── ResourceNotFoundException.java
├── model/              # Entidades JPA
│   ├── Ator.java
│   ├── Diretor.java
│   ├── Filme.java
│   └── Pessoa.java
├── repository/         # Repositórios Spring Data
│   ├── AtorRepository.java
│   ├── DiretorRepository.java
│   └── FilmeRepository.java
├── service/            # Lógica de negócio
│   └── FilmeService.java
└── CatalogoFilmesApplication.java  # Classe principal
```

## 🎯 Modelo de Dados

### Filme
- `id` (Long) - ID único gerado automaticamente
- `titulo` (String) - Título do filme (obrigatório)
- `dataLancamento` (String) - Data de lançamento
- `orcamento` (Double) - Orçamento do filme (obrigatório)
- `descricao` (String) - Descrição do filme
- `diretorId` (Long) - ID do diretor
- `atoresIds` (List<Long>) - Lista de IDs dos atores

## 🔍 Tratamento de Erros

A API retorna respostas JSON estruturadas para erros:

```json
{
  "timestamp": "2024-11-02T10:30:00",
  "message": "Filme não encontrado com id: 999",
  "status": 404
}
```

## 📄 Licença

Este projeto foi desenvolvido para fins educacionais.
