package br.com.fiap.digitallibray.model;

import java.util.Random;

public record Livros(Long id, String nome, String descricao, double preco) {
    public Livros(Long id, String nome, String descricao, double preco){
        this.id = Math.abs(new Random().nextLong());
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }
}
