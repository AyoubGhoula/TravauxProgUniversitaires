package com.sgico.tp5.controller;

import com.sgico.tp5.dto.membre.MembreRequest;
import com.sgico.tp5.dto.membre.MembreResponse;
import com.sgico.tp5.service.MembreService;
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
@RequestMapping("/api/membres")
public class MembreController {

    private final MembreService membreService;

    public MembreController(MembreService membreService) {
        this.membreService = membreService;
    }

    @GetMapping
    public ResponseEntity<List<MembreResponse>> findAll() {
        return ResponseEntity.ok(membreService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MembreResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(membreService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MembreResponse> create(@Valid @RequestBody MembreRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(membreService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MembreResponse> update(@PathVariable Long id, @Valid @RequestBody MembreRequest request) {
        return ResponseEntity.ok(membreService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        membreService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

