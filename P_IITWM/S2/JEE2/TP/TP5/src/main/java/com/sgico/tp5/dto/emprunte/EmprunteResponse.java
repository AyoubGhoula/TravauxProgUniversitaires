package com.sgico.tp5.dto.emprunte;

import java.time.LocalDate;

public class EmprunteResponse {

    private Long id;
    private LocalDate dateEmprunt;
    private LocalDate dateRetour;
    private Long livreId;
    private String livreTitre;
    private Long membreId;
    private String membreNomPrenom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(LocalDate dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
    }

    public Long getLivreId() {
        return livreId;
    }

    public void setLivreId(Long livreId) {
        this.livreId = livreId;
    }

    public String getLivreTitre() {
        return livreTitre;
    }

    public void setLivreTitre(String livreTitre) {
        this.livreTitre = livreTitre;
    }

    public Long getMembreId() {
        return membreId;
    }

    public void setMembreId(Long membreId) {
        this.membreId = membreId;
    }

    public String getMembreNomPrenom() {
        return membreNomPrenom;
    }

    public void setMembreNomPrenom(String membreNomPrenom) {
        this.membreNomPrenom = membreNomPrenom;
    }
}

