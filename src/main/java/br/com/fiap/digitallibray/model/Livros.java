package br.com.fiap.digitallibray.model;

import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
@Entity
public class Livros {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @NotBlank
    String nome; 
    @NotBlank
    String descricao;  
    @NotBlank
    double preco;
}
