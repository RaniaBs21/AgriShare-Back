package com.example.msressources.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Ressource")
public class Ressources implements Serializable {
    @Id
    private String id;
    private String nom;
    private TypeRessource type;
    private Double  quantite;
    private Unite unite;
    private boolean disponibilite;

    public Ressources(String nom, TypeRessource type, Double  quantite, Unite unite, boolean disponibilite) {
        this.nom = nom;
        this.type = type;
        this.quantite = quantite;
        this.unite = unite;
        this.disponibilite = disponibilite;
    }
    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

}






