package com.example.msreclamation.Services;


import com.example.msreclamation.Entities.Reclamation;

import java.util.List;

public interface IReclamationService {
    Reclamation addReclamation(Reclamation reclamation); // Ajouter une réclamation

    Reclamation getReclamationById(Long id); // Récupérer une réclamation par son ID


    List<Reclamation> getAllReclamations(); // Récupérer toutes les réclamations

    void deleteReclamation(Long id); // Supprimer une réclamation
}
