package br.com.fiap.digitallibray.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import br.com.fiap.digitallibray.model.Livros;
import br.com.fiap.digitallibray.repository.LivrosRepository;
import lombok.extern.slf4j.Slf4j;




@RestController
@RequestMapping("livros")
@Slf4j
public class LivrosController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    LivrosRepository livrosRepository;

   @GetMapping
    public List<Livros> index(@PageableDefault(size = 10) Pageable pageable) {
    return livrosRepository.findAll(pageable).getContent();
}

    @GetMapping("maior valor")
    public Livros getMaior(
        @PageableDefault(sort = "valor", direction = Direction.DESC , size = 1) Pageable pageable
    ){
        return livrosRepository.findAll(pageable).getContent().get(0);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livros> show(@PathVariable Long id){

        log.info("Buscando livro com id {}", id);

       return livrosRepository
        .findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());}

        @PostMapping
        @ResponseStatus(CREATED)
    public Livros create(@RequestBody Livros livros){
        log.info("Cadastrando livro {}", livros);

        return livrosRepository.save(livros);
    }

        @DeleteMapping("/{id}")
        @ResponseStatus(NO_CONTENT)
    public void  delete(@PathVariable Long id){
        log.info("Deletando mouse com id {}");

        verificarLivro(id);
        livrosRepository.deleteById(id);
        

    }

    private void verificarLivro(Long id){
        livrosRepository
        .findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não exite Livro com esse id "));

    }

    @PutMapping("{id}")
    public Livros editaLivros(@PathVariable Long id, @RequestBody Livros livros){
        log.info("Atualizando Livros do Id {} para a {} ", id, livros);

        verificarLivro(id);
        livros.setId(id);

        return livrosRepository.save(livros);

    }

    


}
