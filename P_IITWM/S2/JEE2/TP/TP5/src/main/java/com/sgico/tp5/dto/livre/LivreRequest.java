package com.sgico.tp5.dto.livre;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LivreRequest {

    @NotBlank(message = "Le titre est obligatoire")
    @Size(max = 150, message = "Le titre ne doit pas depasser 150 caracteres")
    private String titre;

    @NotBlank(message = "L'auteur est obligatoire")
    @Size(max = 120, message = "L'auteur ne doit pas depasser 120 caracteres")
    private String auteur;

    @NotBlank(message = "L'ISBN est obligatoire")
    @Pattern(regexp = "^[0-9-]{10,17}$", message = "Le format ISBN est invalide")
    private String isbn;

    private Boolean disponible;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
}

