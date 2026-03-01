package example.bibliotheque.controller;
import example.bibliotheque.entities.Auteur;
import example.bibliotheque.service.AuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/auteurs")
public class AuteurController {
    @Autowired
    private AuteurService auteurService;

    @GetMapping
    public String viewAuteursPage(Model model) {
        model.addAttribute("listAuteurs", auteurService.getAllAuteurs());
        return "auteurs";
    }

    @GetMapping("/new")
    public String showNewAuteurForm(Model model) {
        Auteur auteur = new Auteur();
        model.addAttribute("auteur", auteur);
        return "new_auteur";
    }

    @PostMapping("/save")
    public String saveAuteur(@ModelAttribute("auteur") Auteur auteur) {
        auteurService.saveAuteur(auteur);
        return "redirect:/auteurs";
    }

    @GetMapping("/edit/{id}")
    public String showEditAuteurForm(@PathVariable("id") Long id, Model model) {
        Optional<Auteur> auteur = auteurService.getAuteurById(id);
        model.addAttribute("auteur", auteur.orElse(new Auteur()));
        return "edit_auteur";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuteur(@PathVariable("id") Long id) {
        auteurService.deleteAuteur(id);
        return "redirect:/auteurs";
    }
}