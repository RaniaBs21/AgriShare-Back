package com.example.msressources.services;
import com.example.msressources.Repository.EquipementRepository;
import com.example.msressources.Repository.RessourceRepository;
import com.example.msressources.entities.Equipement;
import com.example.msressources.entities.Ressources;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RessourcesService {
    RessourceRepository ressourceRepository;
    EquipementRepository equipementRepository;
    public Ressources ajouterRessource (Ressources ressource) {
        return ressourceRepository.save(ressource);
    }
    public List<Ressources> getAllRessources() {
        return ressourceRepository.findAll();
    }

    public Ressources getRessourceById(String id) {
        return ressourceRepository.findById(id).orElse(null);
    }

    public void deleteRessources(String id) {
        ressourceRepository.deleteById(id);
    }


    public Ressources updateRessources(Ressources ressources, String id) {
        Ressources existingRessources = ressourceRepository.findById(id)
                .orElseThrow(() -> new jakarta.persistence.EntityNotFoundException("Entity with id " + id + " not found"));
        existingRessources.setNom(ressources.getNom());
        existingRessources.setDisponibilite(ressources.isDisponibilite());
        existingRessources.setUnite(ressources.getUnite());
        existingRessources.setType(ressources.getType());
        return ressourceRepository.save(existingRessources);
    }






    public Equipement ajouterEquipement (Equipement equipement) {
        return equipementRepository.save(equipement);
    }
    public List<Equipement> getAllEquipements() {
        return equipementRepository.findAll();
    }

    public Equipement getEquipementById(String id) {
        return equipementRepository.findById(id).orElse(null);
    }

    public void deleteEquipements(String id) {
        equipementRepository.deleteById(id);
    }


    public Equipement updateEquipement(Equipement equipement, String id) {
        Equipement existingEquipement = equipementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id " + id + " not found"));
        existingEquipement.setNomEquipement(equipement.getNomEquipement());
        existingEquipement.setType(equipement.getType());
        return equipementRepository.save(existingEquipement);
    }


}
