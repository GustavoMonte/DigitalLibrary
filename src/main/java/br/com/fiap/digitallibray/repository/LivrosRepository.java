package br.com.fiap.digitallibray.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.digitallibray.model.Livros;

public interface LivrosRepository extends JpaRepository<Livros, Long>{

    

}
