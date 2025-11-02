# 🚀 Guia Rápido de Inicialização

## Pré-requisitos
- Java 17 ou superior instalado
- Maven instalado (ou usar o Maven Wrapper)

## Passos para Executar

### 1️⃣ Compilar o projeto
```bash
mvn clean install
```

### 2️⃣ Executar a aplicação
```bash
mvn spring-boot:run
```

### 3️⃣ Testar a API

**Listar filmes:**
```bash
curl http://localhost:8080/filmes
```

**Criar um filme:**
```bash
curl -X POST http://localhost:8080/filmes ^
  -H "Content-Type: application/json" ^
  -d "{\"titulo\":\"Matrix\",\"dataLancamento\":\"1999-03-31\",\"orcamento\":63000000,\"descricao\":\"Um hacker descobre a verdade\"}"
```

### 4️⃣ Acessar o Console H2
Abra no navegador: http://localhost:8080/h2-console

**Credenciais:**
- JDBC URL: `jdbc:h2:mem:catalogodb`
- User: `sa`
- Password: (deixe vazio)

## 🎯 Endpoints Disponíveis

| Método | URL | Descrição |
|--------|-----|-----------|
| GET | http://localhost:8080/filmes | Lista todos |
| GET | http://localhost:8080/filmes/1 | Busca por ID |
| POST | http://localhost:8080/filmes | Cria novo |
| PUT | http://localhost:8080/filmes/1 | Atualiza completo |
| PATCH | http://localhost:8080/filmes/1 | Atualiza parcial |
| DELETE | http://localhost:8080/filmes/1 | Remove |

## 📦 Testando com Postman
Importe o arquivo: `Catalogo_Filmes_API.postman_collection.json`

## ✅ A aplicação está rodando quando você ver:
```
Started CatalogoFilmesApplication in X.XXX seconds
```

## 🛑 Para parar a aplicação
Pressione `Ctrl + C` no terminal
