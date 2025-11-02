# Catálogo de Filmes

Bem-vindo ao projeto de Catálogo de Filmes!

Este projeto foi desenvolvido em grupo para o curso de backend em Java. O objetivo é criar um sistema simples para catalogar filmes, inspirado em plataformas como o IMDB.

## 🚀 Funcionalidades

O sistema permite que o usuário faça o seguinte:

-   **Cadastrar filmes**: Adicionar informações como nome, data de lançamento, orçamento e descrição.
-   **Cadastrar pessoas**: Registrar diretores e atores.
-   **Associar filmes e pessoas**: Conectar um filme aos seus diretores e atores.
-   **Pesquisar filmes**: Encontrar filmes pelo nome, sem se preocupar com letras maiúsculas ou minúsculas.

## 🧠 Conceitos de Programação Aplicados

Durante o desenvolvimento deste projeto, estou praticando os seguintes conceitos de Programação Orientada a Objetos (POO):

-   **Encapsulamento**: Atributos como nome e orçamento do filme são protegidos e acessados apenas por métodos (`getters` e `setters`).
-   **Herança**: As classes `Ator` e `Diretor` herdam características da classe `Pessoa`, o que evita a repetição de código.
-   **Polimorfismo**: (Este conceito pode ser adicionado em futuras implementações).
-   **Classes Abstratas**: A classe `Pessoa` é uma classe abstrata que serve como base para `Ator` e `Diretor`.

## 💻 Estrutura do Código

O código está organizado da seguinte forma:

-   **`Pessoa`**: Uma classe **abstrata** que define os atributos básicos de uma pessoa, como nome.
-   **`Ator` e `Diretor`**: Classes que herdam de `Pessoa`, representando os papéis no filme.
-   **`Filme`**: Uma classe que representa um filme, com seus atributos e listas de atores e um diretor.
-   **`Catalogo`**: A classe Catalogo é uma classe central que gerencia todo o sistema de catálogo de filmes.
-   **`Main`**: Esta classe serve como ponto de entrada principal do programa de catálogo de filmes.

## 🎬 Como Usar

### Versão Console (Original)

1.  Clone este repositório para a sua máquina: https://github.com/regigomes/poo-filmes-java.git
2.  Abra o projeto na sua IDE favorita (como o VS Code, Eclipse ou IntelliJ).
3.  Execute a classe `Main.java`.
4.  Siga as instruções no console para cadastrar, associar e pesquisar filmes.

### Versão API REST (Nova Implementação)

Este projeto foi expandido para incluir uma **API REST completa** usando **Spring Boot**! 🚀

#### ✨ Novas Funcionalidades da API

- **RESTful API**: Endpoints HTTP para todas as operações CRUD
- **Banco de Dados H2**: Persistência de dados em memória
- **Spring Data JPA**: Gerenciamento automático de dados
- **Validações**: Bean Validation para garantir integridade dos dados
- **Console H2**: Interface web para visualizar o banco de dados
- **Documentação Completa**: README detalhado e coleção Postman

#### 📋 Endpoints Disponíveis

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/filmes` | Lista todos os filmes |
| GET | `/filmes/{id}` | Busca filme por ID |
| POST | `/filmes` | Cria novo filme |
| PUT | `/filmes/{id}` | Atualiza filme completo |
| PATCH | `/filmes/{id}` | Atualiza filme parcialmente |
| DELETE | `/filmes/{id}` | Remove filme |

#### 🚀 Como Executar a API

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/regigomes/catalogo-filmes-api.git
   cd catalogo-filmes-api
   ```

2. **Compile o projeto:**
   ```bash
   mvn clean install
   ```

3. **Execute a aplicação:**
   ```bash
   mvn spring-boot:run
   ```

4. **Acesse a API:**
   - API REST: http://localhost:8080/filmes
   - Console H2: http://localhost:8080/h2-console
     - JDBC URL: `jdbc:h2:mem:catalogodb`
     - User: `sa`
     - Password: (deixe vazio)

#### 📝 Exemplos de Uso

**Listar todos os filmes:**
```bash
curl http://localhost:8080/filmes
```

**Criar um novo filme:**
```bash
curl -X POST http://localhost:8080/filmes \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Matrix",
    "dataLancamento": "1999-03-31",
    "orcamento": 63000000,
    "descricao": "Um hacker descobre a verdade sobre sua realidade"
  }'
```

**Buscar filme por ID:**
```bash
curl http://localhost:8080/filmes/1
```

**Atualizar parcialmente um filme:**
```bash
curl -X PATCH http://localhost:8080/filmes/1 \
  -H "Content-Type: application/json" \
  -d '{"orcamento": 100000000}'
```

**Deletar um filme:**
```bash
curl -X DELETE http://localhost:8080/filmes/1
```

#### 🏗️ Arquitetura da API

```
┌─────────────────────────────────────────┐
│         REST API (HTTP/JSON)            │
├─────────────────────────────────────────┤
│  Controller Layer (FilmeController)     │ ← Endpoints REST
├─────────────────────────────────────────┤
│  Service Layer (FilmeService)           │ ← Lógica de negócio
├─────────────────────────────────────────┤
│  Repository Layer (Spring Data JPA)     │ ← Acesso a dados
├─────────────────────────────────────────┤
│  Entity Layer (Filme, Ator, Diretor)    │ ← Modelo de domínio
├─────────────────────────────────────────┤
│  Database H2 (In-Memory)                │ ← Persistência
└─────────────────────────────────────────┘
```

#### 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Data JPA** - Persistência de dados
- **Spring Web** - API REST
- **H2 Database** - Banco de dados em memória
- **Lombok** - Redução de boilerplate
- **Bean Validation** - Validação de dados
- **Maven** - Gerenciamento de dependências

#### 📚 Documentação Adicional

- [README_API.md](README_API.md) - Documentação completa da API
- [INICIO_RAPIDO.md](INICIO_RAPIDO.md) - Guia de início rápido
- [Catalogo_Filmes_API.postman_collection.json](Catalogo_Filmes_API.postman_collection.json) - Coleção Postman para testes

---
