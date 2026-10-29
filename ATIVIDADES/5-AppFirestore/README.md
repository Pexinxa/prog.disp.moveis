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

## Configurar o Firebase na sua conta

O `app/google-services.json` atual é do projeto `appfirestore-c44eb`. O antigo apontava para o projeto do professor (`appkotlin-9418b`). Para refazer em outra conta:

1. Acesse <https://console.firebase.google.com> com a sua conta Google.
2. **Adicionar projeto** → nome, por exemplo `AppFirestore` → pode desativar o Google Analytics → **Criar projeto**.
3. Na visão geral do projeto, clique no ícone **Android** para registrar o app:
   - Nome do pacote: `br.edu.fatecpg.appfirebase` (precisa ser exatamente este)
   - Apelido: `AppFirestore` (opcional)
   - **Registrar app** → **Baixar google-services.json**
4. Copie o arquivo baixado para `AppFirestore/app/google-services.json`.
   Pule os passos de "Adicionar SDK": o projeto já está configurado.
5. No menu lateral: **Criação → Firestore Database → Criar banco de dados**.
   - Local: `southamerica-east1 (São Paulo)`
   - Escolha **Iniciar no modo de teste** → **Criar**.
   Mantenha as regras padrão do modo de teste (valem por 30 dias a partir da criação).
6. No Android Studio: **File → Sync Project with Gradle Files** e rode o app.
   Cadastre um produto e confira em **Firestore Database → Dados → Produtos**.

## Correções feitas no projeto original

| Problema | Correção |
|---|---|
| `->` solto no bloco `plugins` de `app/build.gradle.kts` (erro de sintaxe) | Removido |
| AGP 8.13.2 com Gradle 8.10.2 (o AGP 8.13 exige Gradle 8.13+), e daemon em JDK 25, que o Gradle 8.x não suporta | AGP 8.10.0 (máximo suportado pelo Android Studio usado) + Gradle 8.11.1, sem toolchain fixo do daemon |
| `kotlinOptions` (vira erro no Kotlin 2.2+) e `jvmTarget = "21"` diferente de `JavaVersion.VERSION_11` | `kotlin { compilerOptions { jvmTarget = JVM_11 } }`, alinhado com o Java 11 |
| `compileSdk = 37` e bibliotecas AndroidX que exigem AGP 9 | `compileSdk = 36` e versões de bibliotecas compatíveis com o AGP 8.10 |
| `proguard-rules.pro` referenciado, mas inexistente | Removida a referência (minify está desativado) |
| `google-services.json` do projeto do professor | Trocado pelo do projeto `appfirestore-c44eb` |
| `local.properties` com o caminho do SDK de outro PC | Removido (é gerado pelo Android Studio) |
| `enableEdgeToEdge()` sem tratar os insets (conteúdo atrás da status bar) | Insets aplicados em cada tela |
| Escrita fixa no `onCreate` (`colecao_cliente/doc_cliente2`) | Substituída pelas telas de cadastro e de listagem |
