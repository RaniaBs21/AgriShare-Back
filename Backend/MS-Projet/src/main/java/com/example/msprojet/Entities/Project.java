package com.example.msprojet.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Project")
public class Project {
    @Id
    private String id;
    private String nom;
    private String description;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private List<String> etapes; // Liste des étapes du projet
    private Statut statut; // Statut du projet, ex: "En cours", "Terminé"
    private String cooperativeId;
}
