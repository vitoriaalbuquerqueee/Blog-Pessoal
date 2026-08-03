package com.generation.blogpessoal.controller;

import java.util.List;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {

    private final PostagemRepository postagemRepository;

    public PostagemController(PostagemRepository postagemRepository) {
        this.postagemRepository = postagemRepository;
    }

    @GetMapping
    public ResponseEntity<List<Postagem>> getAll() {
        return ResponseEntity.ok(postagemRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postagem> getById(@PathVariable Long id) {
        return postagemRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo) {
        return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
    }

    @PostMapping
    public ResponseEntity<Postagem> post(@Valid @RequestBody Postagem postagem) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(postagemRepository.save(postagem));
    }

    @PutMapping
    public ResponseEntity<Postagem> put(@Valid @RequestBody Postagem postagem) {
        return postagemRepository.findById(postagem.getId())
                .map(resposta -> ResponseEntity.status(HttpStatus.OK)
                        .body(postagemRepository.save(postagem)))
                .orElse(ResponseEntity.notFound().build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        postagemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        postagemRepository.deleteById(id);
    }

}