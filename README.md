# Catálogo de Filmes

Bem-vindo ao projeto de Catálogo de Filmes!

Este projeto foi feito em grupo para o curso de backend em Java. O objetivo é criar um sistema simples para catalogar filmes, inspirado em plataformas como o IMDB.

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

1.  Clone este repositório para a sua máquina: https://github.com/regigomes/poo-filmes-java.git
2.  Abra o projeto na sua IDE favorita (como o VS Code, Eclipse ou IntelliJ).
3.  Execute a classe `Main.java`.
4.  Siga as instruções no console para cadastrar, associar e pesquisar filmes.

---
