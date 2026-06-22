# Gestão de Produtos JDBC + JavaFX

![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=java)
![JavaFX](https://img.shields.io/badge/JavaFX-21-blue?style=flat-square)
![SQLite](https://img.shields.io/badge/SQLite-3-lightblue?style=flat-square&logo=sqlite)
![License](https://img.shields.io/badge/license-MIT-green?style=flat-square)

## 📌 Sobre o Projeto

Aplicação desktop para **gerenciamento de estoque de produtos**, desenvolvida com interface gráfica JavaFX e persistência local em banco de dados SQLite via JDBC. Permite cadastrar, editar, excluir e visualizar produtos em tempo real, sem necessidade de servidor ou configuração externa.

## 🚀 Tecnologias Utilizadas

- Java 21
- JavaFX 21
- SQLite (banco de dados local via JDBC)
- Eclipse IDE

## 🏗️ Arquitetura

O projeto segue uma estrutura em camadas simples, toda dentro do pacote `application`:

```
ProdutoGUI          ← Interface gráfica (JavaFX)
     │
ProdutoDAO          ← Acesso ao banco de dados (CRUD)
     │
ConexaoDB           ← Gerenciamento da conexão JDBC com o SQLite
     │
Produto             ← Modelo/entidade com os atributos do produto
CriadorTabela       ← Utilitário para criação inicial da tabela no banco
```

## 📋 Funcionalidades

- **Adicionar produto** — preencha nome, quantidade, preço e status e clique em *Adicionar*
- **Atualizar produto** — selecione um produto na tabela, edite os campos e clique em *Atualizar*
- **Excluir produto** — selecione um produto na tabela e clique em *Excluir*
- **Listar produtos** — a tabela exibe todos os produtos cadastrados e é atualizada automaticamente após cada operação
- **Preenchimento automático** — clicar em um produto na tabela preenche o formulário com seus dados
- **Limpar campos** — botão *Limpar* reseta o formulário sem afetar o banco
- **Suporte a vírgula no preço** — o campo de preço aceita tanto `.` quanto `,` como separador decimal

### Status disponíveis

| Status | Descrição |
|---|---|
| Estoque Normal | Produto com quantidade adequada |
| Estoque Baixo | Produto com quantidade reduzida |

## 🗃️ Estrutura do Banco de Dados

**Tabela: `produtos`**

| Coluna | Tipo | Descrição |
|---|---|---|
| `id_produto` | INTEGER PRIMARY KEY | Identificador único (autoincremento) |
| `nome_produto` | TEXT NOT NULL | Nome do produto |
| `quantidade` | INTEGER | Quantidade em estoque |
| `preco` | REAL | Preço unitário |
| `status` | TEXT | Status do estoque |

## ▶️ Como Executar

### Pré-requisitos

- [JDK 21](https://www.oracle.com/java/technologies/downloads/)
- [JavaFX SDK 21](https://gluonhq.com/products/javafx/) — configure como User Library `JavaFX` no Eclipse
- Eclipse IDE (ou outra IDE com suporte a JavaFX)

### 1. Clone o repositório

```bash
git clone https://github.com/MarceloJustin/GestaoDeProdutosJDBC.git
cd GestaoDeProdutosJDBC
```

### 2. Configure o JavaFX no Eclipse

1. Vá em **Window → Preferences → Java → Build Path → User Libraries**
2. Crie uma biblioteca chamada `JavaFX` e adicione todos os `.jar` do diretório `lib` do JavaFX SDK

### 3. Crie o banco de dados (apenas na primeira execução)

Execute a classe `CriadorTabela.java` como aplicação Java. Isso cria o arquivo `meu_banco_de_dados.db` e a tabela `produtos` na raiz do projeto.

### 4. Execute a aplicação

Execute a classe `ProdutoGUI.java` como aplicação JavaFX.

> **Nota:** se o Eclipse exibir erro de módulo, adicione os seguintes argumentos de VM em **Run Configurations → Arguments → VM arguments**:
> ```
> --module-path /caminho/para/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml
> ```

## 👨‍💻 Autor

Desenvolvido por **Marcelo Justin**

[![GitHub](https://img.shields.io/badge/GitHub-MarceloJustin-black?style=flat-square&logo=github)](https://github.com/MarceloJustin)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-marcelojustin-blue?style=flat-square&logo=linkedin)](https://www.linkedin.com/in/marcelojustin)

## 📄 Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
