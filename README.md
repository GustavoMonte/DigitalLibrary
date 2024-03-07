# DigitalLibrary
API do projeto LivrariaDigital - Compra de livros 
## Tarefas

- [] CRUD LIVROS
- [] CRUD USUÁRIO
- [] CRUD CARRINHO
- [] CRUD MINHA BIBLIOTECA
- [] CRUD FAVORITO
- [] PESQUISAR


## Documentação da API

### Endpoints
- [Listar os Livros ](#listar-todos-os-livro)
- [Detalhes do Livro ](#detalhes-do-livro)
- [Cadastrar Livro ](#cadastrar-livro)
- [Remover Livro ](#remover-livro)


### Listar os Livros Favoritos

`GET` /livros

Retorna um array com todos os seus livros.

#### Exemplo de Resposta

```js
[
    {
        "id": 1,
        "nome": "Nada Pode Me Ferir",
        "preco": 20
    }
]
```

#### Códigos de Status
|código | descrição |
|-------|-----------|
| 200 | Os dados dos favoritos foram retornados com sucesso
| 401 | Acesso Inválido! Você deve se autenticar|
---

### Detalhes dos Livros Favoritos

`GET` /livros/`{id}`

Retorna detalhes dos livros.

#### Exemplo de Resposta

```js
[
    {
        "id": 1,
        "nome": "Nada Pode Me Ferir",
        "preco": 20 ,
        "descricao": "A história de superação do único homem a completar o treinamento das forças de elite e se tornar Navy SEAL, Army Ranger e TACP."
    }
]

```

#### Códigos de Status
|código | descrição |
|-------|-----------|
| 200 | Os dados do livro foram retornados com sucesso
| 401 | Acesso Inválido, Você deve se autenticar|
| 404 | Não existe Livro com esse id

---

### Cadastrar Livros

`POST` /livros

Adiciona um novo livros para a página de livros

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:-----------:|---------|
|nome|string|✅|Nome do livro.
|descricao|string|✅|Descrição do livro.
|preco|double|❌|Preço do livro.

```js
{
    "nome": "Nada Pode Me Ferir",
    "descricao": "A história de superação do único homem a completar o treinamento das forças de elite e se tornar Navy SEAL, Army Ranger e TACP.",
    "preco": 20
}
```

#### Exemplo de Resposta

```js
{
    "id": 1,
    "nome": "Nada Pode Me Ferir",
    "descricao": "A história de superação do único homem a completar o treinamento das forças de elite e se tornar Navy SEAL, Army Ranger e TACP.",
    "preco": 20
}
```

#### Códigos de Status

|código|descrição|

|------|---------|
|201|Mouse cadastrado com sucesso.
|400|Dados enviados são inválidos. Verifique o corpo da requisição.
|401|Acesso negado. Você deve se autenticar.

---



### Remover livro 

`DELETE` /livros/`{id}`

Deleta livros no `id` informado

#### Códigos de Status

|código | descrição |
|-------|-----------|
|204 | Livro removido com êxito
| 404 | Não existe livro com esse parâmetro |
| 401 | Acesso Inválido! Você deve se autenticar |
---


