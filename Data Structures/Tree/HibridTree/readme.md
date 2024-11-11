# Agenda de Contatos

## Classes e Estrutura

### 1. Classe **Contato**
Define as informações básicas de um contato.

- **Atributos**:
  - `String nome`: Nome do contato.
  - `String telefone`: Número de telefone do contato.
  - `String email`: E-mail do contato.
  - `int CPF`: CPF do contato.

---

### 2. Classe **Celula**
Representa uma célula de uma lista encadeada.

- **Atributos**:
  - `Contato contato`: Referência ao contato armazenado na célula.
  - `Celula prox`: Referência à próxima célula na lista.

---

### 3. Classe **No**
Representa um nó da árvore.

- **Atributos**:
  - `char letra`: Letra associada ao nó.
  - `No esq`: Referência ao nó filho à esquerda.
  - `No dir`: Referência ao nó filho à direita.
  - `Celula primeiro`: Referência à primeira célula da lista de contatos.
  - `Celula ultimo`: Referência à última célula da lista de contatos.

---

### 4. Classe **Agenda**
Gerencia a árvore de contatos.

- **Atributos**:
  - `No raiz`: Referência ao nó raiz da árvore.

- **Métodos**:
  - `void inserir(Contato contato)`: Insere um contato na agenda.
  - `void remover(String nome)`: Remove um contato pelo nome.
  - `Contato pesquisar(String nome)`: Pesquisa e retorna um contato pelo nome.
  - `Contato pesquisar(int cpf)`: Pesquisa e retorna um contato pelo CPF.

---

## Detalhes de Implementação
- No **construtor** da classe `Agenda`, inicialize a árvore com todos os nós correspondentes às letras do alfabeto (maiúsculas e sem acentos).
- Para cada método, analise e apresente o **melhor** e o **pior caso** de desempenho.
