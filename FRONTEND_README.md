# 🎬 Frontend - Catálogo de Filmes

Frontend simples e moderno para o sistema de catálogo de filmes, desenvolvido com **HTML, CSS e JavaScript puro** (sem frameworks).

## ✨ Características

- ✅ Interface responsiva e moderna
- ✅ Design com gradiente roxo elegante
- ✅ Operações CRUD completas
- ✅ Validação de formulários
- ✅ Modal de confirmação para exclusão
- ✅ Feedback visual para ações do usuário
- ✅ Animações suaves
- ✅ Totalmente funcional sem dependências externas

## 🚀 Como Usar

### Opção 1: Servido pelo Spring Boot (Recomendado)

O frontend está integrado à aplicação Spring Boot e será servido automaticamente!

1. **Inicie a aplicação Spring Boot:**
   ```bash
   mvn spring-boot:run
   ```

2. **Acesse no navegador:**
   ```
   http://localhost:8080
   ```

### Opção 2: Abrir Diretamente no Navegador

Você também pode abrir o arquivo HTML diretamente:

1. Navegue até: `src/main/resources/static/`
2. Abra o arquivo `index.html` no seu navegador

**Nota:** Certifique-se de que a API está rodando em `http://localhost:8080` para que o frontend funcione corretamente.

## 📋 Funcionalidades

### ➕ Adicionar Filme
- Preencha o formulário com título, data de lançamento, orçamento e descrição
- Clique em "Adicionar Filme"
- O filme aparecerá instantaneamente na lista

### ✏️ Editar Filme
- Clique no botão "Editar" no card do filme
- O formulário será preenchido com os dados atuais
- Modifique os campos desejados
- Clique em "Atualizar Filme"

### 🗑️ Excluir Filme
- Clique no botão "Excluir" no card do filme
- Confirme a exclusão no modal
- O filme será removido da lista

### 🔄 Atualizar Lista
- Clique no botão "Atualizar" para recarregar todos os filmes
- Útil para sincronizar alterações feitas por outros usuários

## 🎨 Tecnologias

- **HTML5** - Estrutura semântica
- **CSS3** - Estilização moderna com gradientes e animações
- **JavaScript (ES6+)** - Lógica e comunicação com a API
- **Fetch API** - Requisições HTTP assíncronas

## 📱 Responsividade

O frontend é totalmente responsivo e se adapta a diferentes tamanhos de tela:

- 📱 Mobile (< 768px)
- 💻 Tablet (768px - 1024px)
- 🖥️ Desktop (> 1024px)

## 🎯 Estrutura de Arquivos

```
src/main/resources/static/
├── index.html      # Estrutura HTML principal
├── styles.css      # Estilos e animações
└── script.js       # Lógica JavaScript e integração com API
```

## 🔌 API Endpoints Utilizados

O frontend consome os seguintes endpoints da API:

| Método | Endpoint | Uso |
|--------|----------|-----|
| GET | `/filmes` | Listar todos os filmes |
| GET | `/filmes/{id}` | Buscar filme por ID |
| POST | `/filmes` | Criar novo filme |
| PUT | `/filmes/{id}` | Atualizar filme |
| DELETE | `/filmes/{id}` | Excluir filme |

## 🎨 Paleta de Cores

```css
Primary: #2563eb (Azul)
Danger: #dc2626 (Vermelho)
Success: #16a34a (Verde)
Warning: #ea580c (Laranja)
Background Gradient: #667eea → #764ba2 (Roxo)
```

## 🚧 Melhorias Futuras

- [ ] Adicionar paginação para listas grandes
- [ ] Implementar busca/filtro de filmes
- [ ] Adicionar gerenciamento de atores e diretores
- [ ] Implementar upload de imagens dos filmes
- [ ] Adicionar gráficos de estatísticas
- [ ] Implementar modo escuro

## 🐛 Troubleshooting

### Erro de CORS
Se você encontrar erros de CORS, certifique-se de que:
1. A API Spring Boot está rodando
2. A classe `CorsConfig.java` está configurada corretamente

### Filmes não aparecem
1. Verifique se a API está rodando em `http://localhost:8080`
2. Abra o Console do navegador (F12) para ver possíveis erros
3. Verifique se há filmes cadastrados no banco

### Formulário não envia
1. Certifique-se de preencher os campos obrigatórios (*)
2. Verifique a conexão com a API
3. Veja o Console do navegador para mensagens de erro

## 📄 Licença

Este projeto faz parte do curso de backend em Java e é livre para uso educacional.

---

**Desenvolvido com ❤️ para o curso de Backend Java**
