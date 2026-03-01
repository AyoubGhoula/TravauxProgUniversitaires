package dev.exemple.controller;

import dev.exemple.entite.Etudiant;
import dev.exemple.repository.EtudiantRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantApiController {

    private final EtudiantRepository repository;

    public EtudiantApiController(EtudiantRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Etudiant> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Etudiant add(@RequestBody Etudiant etudiant) {
        return repository.save(etudiant);
    }
}
