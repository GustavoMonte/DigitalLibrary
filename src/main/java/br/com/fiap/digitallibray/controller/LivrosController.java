package br.com.fiap.digitallibray.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.digitallibray.model.Livros;

@RestController
@RequestMapping("livros")
public class LivrosController {
    

    Logger log = LoggerFactory.getLogger(getClass());

    List<Livros> livrosRepository = new ArrayList<>();


    @PostMapping
    public ResponseEntity<Livros> create(@RequestBody Livros livros){
        log.info("Cadastrando livro {}", livros);
        livrosRepository.add(livros);
        return ResponseEntity.status(HttpStatus.CREATED).body(livros);
    }

    @GetMapping
    public List<Livros> index(){
        return livrosRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livros> show(@PathVariable Long id){
        log.info("Buscando livro com id {}", id);

        for(Livros livros: livrosRepository){
            if (livros.id().equals(id))
                return ResponseEntity.status(HttpStatus.OK).body(livros);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Livros> delete(@PathVariable Long id){
        log.info("Deletando mouse com id {}");

        for(Livros livros:livrosRepository){
            if(livros.id().equals(id)){
                livrosRepository.remove(livros);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(livros);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
