package com.sgico.tp5.controller;

import com.sgico.tp5.dto.emprunte.EmprunteRequest;
import com.sgico.tp5.dto.emprunte.EmprunteResponse;
import com.sgico.tp5.dto.emprunte.RetourRequest;
import com.sgico.tp5.service.EmprunteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/emprunts")
public class EmprunteController {

    private final EmprunteService emprunteService;

    public EmprunteController(EmprunteService emprunteService) {
        this.emprunteService = emprunteService;
    }

    @GetMapping
    public ResponseEntity<List<EmprunteResponse>> findAll() {
        return ResponseEntity.ok(emprunteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmprunteResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(emprunteService.findById(id));
    }

    @PostMapping("/borrow")
    public ResponseEntity<EmprunteResponse> borrow(@Valid @RequestBody EmprunteRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(emprunteService.createEmprunt(request));
    }

    @PostMapping("/{id}/return")
    public ResponseEntity<EmprunteResponse> returnBook(@PathVariable Long id, @Valid @RequestBody(required = false) RetourRequest request) {
        return ResponseEntity.ok(emprunteService.retournerLivre(id, request));
    }
}

