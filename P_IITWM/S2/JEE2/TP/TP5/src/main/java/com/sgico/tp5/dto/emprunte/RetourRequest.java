package com.sgico.tp5.dto.emprunte;

import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class RetourRequest {

    @PastOrPresent(message = "La date de retour ne peut pas etre dans le futur")
    private LocalDate dateRetour;

    public LocalDate getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
    }
}

