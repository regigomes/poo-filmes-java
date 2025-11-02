package com.catalogo.filmes.controller;

import com.catalogo.filmes.dto.FilmeDTO;
import com.catalogo.filmes.service.FilmeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    /**
     * GET /filmes - Retorna todos os filmes
     */
    @GetMapping
    public ResponseEntity<List<FilmeDTO>> getAllFilmes() {
        List<FilmeDTO> filmes = filmeService.findAll();
        return ResponseEntity.ok(filmes);
    }

    /**
     * GET /filmes/{id} - Retorna um filme por ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<FilmeDTO> getFilmeById(@PathVariable Long id) {
        FilmeDTO filme = filmeService.findById(id);
        return ResponseEntity.ok(filme);
    }

    /**
     * POST /filmes - Cria um novo filme
     */
    @PostMapping
    public ResponseEntity<FilmeDTO> createFilme(@Valid @RequestBody FilmeDTO filmeDTO) {
        FilmeDTO createdFilme = filmeService.create(filmeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFilme);
    }

    /**
     * PUT /filmes/{id} - Atualiza completamente um filme
     */
    @PutMapping("/{id}")
    public ResponseEntity<FilmeDTO> updateFilme(@PathVariable Long id,
                                                 @Valid @RequestBody FilmeDTO filmeDTO) {
        FilmeDTO updatedFilme = filmeService.update(id, filmeDTO);
        return ResponseEntity.ok(updatedFilme);
    }

    /**
     * PATCH /filmes/{id} - Atualiza parcialmente um filme
     */
    @PatchMapping("/{id}")
    public ResponseEntity<FilmeDTO> partialUpdateFilme(@PathVariable Long id,
                                                         @RequestBody FilmeDTO filmeDTO) {
        FilmeDTO updatedFilme = filmeService.partialUpdate(id, filmeDTO);
        return ResponseEntity.ok(updatedFilme);
    }

    /**
     * DELETE /filmes/{id} - Deleta um filme
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilme(@PathVariable Long id) {
        filmeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
