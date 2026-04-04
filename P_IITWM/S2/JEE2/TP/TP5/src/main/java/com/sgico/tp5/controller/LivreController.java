package com.sgico.tp5.controller;

import com.sgico.tp5.dto.livre.LivreRequest;
import com.sgico.tp5.dto.livre.LivreResponse;
import com.sgico.tp5.service.LivreService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/livres")
public class LivreController {

    private final LivreService livreService;

    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }

    @GetMapping
    public ResponseEntity<List<LivreResponse>> findAll() {
        return ResponseEntity.ok(livreService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivreResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(livreService.findById(id));
    }

    @PostMapping
    public ResponseEntity<LivreResponse> create(@Valid @RequestBody LivreRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(livreService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivreResponse> update(@PathVariable Long id, @Valid @RequestBody LivreRequest request) {
        return ResponseEntity.ok(livreService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        livreService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

