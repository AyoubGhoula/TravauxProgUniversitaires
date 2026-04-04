package com.sgico.tp5.dto.membre;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MembreRequest {

    @NotBlank(message = "Le nom prenom est obligatoire")
    @Size(max = 120, message = "Le nom prenom ne doit pas depasser 120 caracteres")
    private String nomPrenom;

    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "Le format de l'email est invalide")
    @Size(max = 120, message = "L'email ne doit pas depasser 120 caracteres")
    private String email;

    public String getNomPrenom() {
        return nomPrenom;
    }

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

