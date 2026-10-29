# AppFirestore: Cadastro de Produtos

Tarefa da Aula 11 (Kotlin Android + Firestore): uma tela para **cadastrar produtos** e outra para **listar todos os produtos**.

- Coleção: `Produtos`
- Documento: ID gerado automaticamente (`collection.add()`)
- Campos: `nome` (string), `categoria` (string), `preco` (number)

## Estrutura

```
app/src/main/java/br/edu/fatecpg/appfirebase/
├── model/Produto.kt                 # data class mapeada para o documento
├── data/ProdutoRepository.kt        # Singleton + Facade de acesso ao Firestore
└── ui/
    ├── CadastroProdutoActivity.kt   # tela 1: formulário (tela inicial)
    ├── ListaProdutosActivity.kt     # tela 2: lista em tempo real (Observer)
    └── ProdutoAdapter.kt            # RecyclerView ListAdapter
```
