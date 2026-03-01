package example.bibliotheque.controller;



import example.bibliotheque.entities.Categorie;
import example.bibliotheque.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;

    @GetMapping
    public String viewCategoriesPage(Model model) {
        model.addAttribute("listCategories", categorieService.getAllCategories());
        return "categories";
    }

    @GetMapping("/new")
    public String showNewCategorieForm(Model model) {
        Categorie categorie = new Categorie();
        model.addAttribute("categorie", categorie);
        return "new_categorie";
    }

    @PostMapping("/save")
    public String saveCategorie(@ModelAttribute("categorie") Categorie categorie) {
        categorieService.saveCategorie(categorie);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String showEditCategorieForm(@PathVariable("id") Long id, Model model) {
        Optional<Categorie> categorie = categorieService.getCategorieById(id);
        model.addAttribute("categorie", categorie.orElse(new Categorie()));
        return "edit_categorie";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategorie(@PathVariable("id") Long id) {
        categorieService.deleteCategorie(id);
        return "redirect:/categories";
    }
}