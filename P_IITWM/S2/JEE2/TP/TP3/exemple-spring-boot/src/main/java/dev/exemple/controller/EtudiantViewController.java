package dev.exemple.controller;

import dev.exemple.repository.EtudiantRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EtudiantViewController {

    private final EtudiantRepository repository;

    public EtudiantViewController(EtudiantRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/liste")
    public String afficherEtudiants(Model model) {
        model.addAttribute("etudiants", repository.findAll());
        return "etudiants";
    }
}
