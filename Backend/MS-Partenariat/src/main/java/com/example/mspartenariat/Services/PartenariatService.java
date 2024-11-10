package com.example.mspartenariat.Services;

import com.example.mspartenariat.Entities.Partenariat;
import com.example.mspartenariat.Repositories.PartenariatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class PartenariatService {
    @Autowired
    private PartenariatRepository partenariatRepository;
    // Méthode pour convertir l'image en base64
    private String convertImageToBase64(byte[] image) {
        return Base64.getEncoder().encodeToString(image);
    }
    // Ajouter un partenariat
    public Partenariat addPartenariat(Partenariat partenariat) {
        return partenariatRepository.save(partenariat);
    }

    // Récupérer tous les partenariats
    public List<Partenariat> getAll() {
        List<Partenariat> partenariats = partenariatRepository.findAll();

        // Convertir les images en base64 pour chaque partenariat
        for (Partenariat p : partenariats) {
            if (p.getImage() != null) {
                p.setImageBase64(convertImageToBase64(p.getImage()));
            }
        }

        return partenariats;
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

    public Optional<Partenariat> getPartenariatById(int id) {
        return partenariatRepository.findById(id);
    }


}
