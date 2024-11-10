package com.example.msrecolte.Services;

import com.example.msrecolte.Entities.recolte;
import com.example.msrecolte.Repositories.RecolteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecolteService {

    RecolteRepository recolteRepository;

    public recolte ajouterRecolte(recolte recolte) {
        return recolteRepository.save(recolte);
    }

    public recolte modifierRecolte(String id, recolte nouvelleRecolte) {
        return recolteRepository.findById(id).map(Recolte -> {
            Recolte.setTypeCulture(nouvelleRecolte.getTypeCulture());
            Recolte.setQuantite(nouvelleRecolte.getQuantite());
            Recolte.setSaison(nouvelleRecolte.getSaison());
            Recolte.setDateRecolte(nouvelleRecolte.getDateRecolte());
            return recolteRepository.save(Recolte);
        }).orElseThrow(() -> new RuntimeException("Récolte non trouvée"));
    }
    public recolte obtenirRecolteParId(String id) {
        return recolteRepository.findById(id).orElse(null);
    }

    public List<recolte> obtenirRecoltes() {
        return recolteRepository.findAll();
    }
    public void supprimerRecolte(String id) {
        recolteRepository.deleteById(id);
    }



    public List<recolte> listerRecoltesParTypeCulture(String typeCulture) {
        return recolteRepository.findByTypeCulture(typeCulture);
    }
    public Double obtenirQuantiteTotaleParTypeCulture(String typeCulture) {
        return recolteRepository.sumQuantiteByTypeCulture(typeCulture);
    }

}
