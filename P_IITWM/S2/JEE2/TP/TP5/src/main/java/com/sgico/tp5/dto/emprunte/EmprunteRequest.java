package com.sgico.tp5.dto.emprunte;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class EmprunteRequest {

    @NotNull(message = "L'identifiant du livre est obligatoire")
    private Long livreId;

    @NotNull(message = "L'identifiant du membre est obligatoire")
    private Long membreId;

    @PastOrPresent(message = "La date d'emprunt ne peut pas etre dans le futur")
    private LocalDate dateEmprunt;

    public Long getLivreId() {
        return livreId;
    }

    public void setLivreId(Long livreId) {
        this.livreId = livreId;
    }

    public Long getMembreId() {
        return membreId;
    }

    public void setMembreId(Long membreId) {
        this.membreId = membreId;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(LocalDate dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }
}

