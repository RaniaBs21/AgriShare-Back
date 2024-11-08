package com.example.mspartenariat.Services;
import com.example.mspartenariat.Entities.Partenariat;
import com.example.mspartenariat.Repositories.PartenariatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartenariatService {
    @Autowired
    private PartenariatRepository partenariatRepository;

    // Ajouter un partenariat
    public Partenariat addPartenariat(Partenariat partenariat) {
        return partenariatRepository.save(partenariat);
    }

    // Récupérer tous les partenariats
    public List<Partenariat> getAll() {
        return partenariatRepository.findAll();
    }

    // Mettre à jour un partenariat par son ID
    public void updatePartenariat(int id, String newEmail, String newNom, String newPrenom, String newNumeroTelephone) {

        // Trouver le partenariat par ID
        Partenariat partenariat = partenariatRepository.findById(id).orElse(null);

        if (partenariat != null) {
            // Mettre à jour les informations
            partenariat.setEmail(newEmail);
            partenariat.setNom(newNom);
            partenariat.setPrenom(newPrenom);
            partenariat.setNumeroTelephone(newNumeroTelephone);

            // Sauvegarder les modifications
            partenariatRepository.save(partenariat);
        }
    }

    // Supprimer un partenariat par son ID
    public String deletePartenariat(int id) {
        if (partenariatRepository.findById(id).isPresent()) {
            partenariatRepository.deleteById(id);
            return "Partenariat supprimé";
        } else {
            return "Partenariat non trouvé";
        }
    }

    // Trouver un partenariat par son ID ou email
    public Partenariat findPartenariatByIdOrEmail(int id, String email) {
             return partenariatRepository.findById(id).orElseGet(() -> partenariatRepository.findByEmail(email).orElse(null));
    }
}
