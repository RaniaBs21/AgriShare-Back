package com.example.msreclamation.Entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Reclamation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReclamation;
    @Nullable
    private String description; // Description de la réclamation
    @Nullable
    private LocalDate dateSoumission; // Date et heure de la soumission de la réclamation

    private Long idMembre; // ID du membre (statique temporairement)

    public Long getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(Long idReclamation) {
        this.idReclamation = idReclamation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateSoumission() {
        return dateSoumission;
    }

    public void setDateSoumission(LocalDate dateSoumission) {
        this.dateSoumission = dateSoumission;
    }

    public Long getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(Long idMembre) {
        this.idMembre = idMembre;
    }
}
