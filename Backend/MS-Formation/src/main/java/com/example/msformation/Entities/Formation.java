package com.example.msformation.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Formation {

    public enum TypeFormation {GUIDE,PRESENTIEL,WEBINAIRE}
    public enum CategorieFormation { AGRICULTURE_BIO, GESTION_COOPERATIVE, MECANISATION, IRRIGATION, COMMERCIALISATION, INNOVATION }

    @Id
    @GeneratedValue
    private Integer   id;
    private String titre;
    private String description;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private TypeFormation type;
    @Enumerated(EnumType.STRING)
    private CategorieFormation categorie;
    public Formation() {
    }


    public Formation(String titre, String description, LocalDate date, TypeFormation type, CategorieFormation categorie) {
        this.titre = titre;
        this.description = description;
        this.date = date;
        this.type = type;
        this.categorie = categorie;
    }

    public Integer   getId() {
        return id;
    }

    public void setId(Integer  id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public TypeFormation getType() {
        return type;
    }

    public void setType(TypeFormation type) {
        this.type = type;
    }

    public CategorieFormation getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieFormation categorie) {
        this.categorie = categorie;
    }
}
