package example.bibliotheque.controller;


import example.bibliotheque.entities.Livre;
import example.bibliotheque.service.AuteurService;
import example.bibliotheque.service.CategorieService;
import example.bibliotheque.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/livres")
public class LivreController {
    @Autowired
    private LivreService livreService;
    @Autowired
    private AuteurService auteurService;
    @Autowired
    private CategorieService categorieService;

    @GetMapping
    public String viewLivresPage(Model model) {
        model.addAttribute("listLivres", livreService.getAllLivres());
        return "livres";
    }

    @GetMapping("/new")
    public String showNewLivreForm(Model model) {
        Livre livre = new Livre();
        model.addAttribute("livre", livre);
        model.addAttribute("auteurs", auteurService.getAllAuteurs());
        model.addAttribute("categories", categorieService.getAllCategories());
        return "new_livre";
    }

    @PostMapping("/save")
    public String saveLivre(@ModelAttribute("livre") Livre livre) {
        livreService.saveLivre(livre);
        return "redirect:/livres";
    }

    @GetMapping("/edit/{id}")
    public String showEditLivreForm(@PathVariable("id") Long id, Model model) {
        Optional<Livre> livre = livreService.getLivreById(id);
        model.addAttribute("livre", livre.orElse(new Livre()));
        model.addAttribute("auteurs", auteurService.getAllAuteurs());
        model.addAttribute("categories", categorieService.getAllCategories());
        return "edit_livre";
    }

    @GetMapping("/delete/{id}")
    public String deleteLivre(@PathVariable("id") Long id) {
        livreService.deleteLivre(id);
        return "redirect:/livres";
    }
}