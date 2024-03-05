# DigitalLibrary
API do projeto LivrariaDigital - Compra de livros 
## Tarefas

- [] CRUD USUÁRIO
- [] CRUD CARRINHO
- [] CRUD MINHA BIBLIOTECA
- [] CRUD FAVORITO
- [] PESQUISAR


## Documentação da API

### Endpoints
- [Listar os Livros Favoritos](#listar-todos-os-favoritos)
- [Detalhes do Livro Favorito](#detalhes-do-favorito)
- [Adicionar Livro Favoritos](#adicionar-favorito)
- [Remover Livro Favoritos](#remover-favorito)


### Listar os Livros Favoritos

`GET` /favoritos

Retorna um array com todos os seus livros favoritos.

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

`GET` /`{id}`

Retorna detalhes dos livros favoritos.

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
| 200 | Os dados do livro favorito foram retornados com sucesso
| 401 | Acesso Inválido, Você deve se autenticar|
| 404 | Não existe Livro com esse id
---



### Remover livro do favorito

`DELETE` /favoritos/`{id}`

Deleta  no `id` informado

#### Códigos de Status

|código | descrição |
|-------|-----------|
|204 | Livro removido com êxito
| 404 | Não existe livro com esse parâmetro |
| 401 | Acesso Inválido! Você deve se autenticar |
---


