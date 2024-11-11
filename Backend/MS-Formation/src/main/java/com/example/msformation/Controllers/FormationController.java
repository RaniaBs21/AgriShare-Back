package com.example.msformation.Controllers;

import com.example.msformation.Entities.Formation;
import com.example.msformation.Services.FormationService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("formation")
@AllArgsConstructor
public class FormationController {
    @Autowired
    private FormationService formationService ;

    // Ajouter une nouvelle formation
    @PostMapping
    public ResponseEntity<Formation> addFormation(@RequestBody Formation formation) {
        Formation createdFormation = formationService.addFormation(formation);
        return new ResponseEntity<>(createdFormation, HttpStatus.CREATED);
    }


    // Obtenir toutes les formations
    @GetMapping
    public ResponseEntity<List<Formation>> getAllFormations() {
        List<Formation> formations = formationService.getAllFormation();
        return new ResponseEntity<>(formations, HttpStatus.OK);
    }

    // Mettre à jour une formation par son ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateFormation(@PathVariable Integer id, @RequestBody Formation updatedFormation) {
        try {
            formationService.updateFormation(id, updatedFormation);
            return new ResponseEntity<>("Formation mise à jour avec succès", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Supprimer une formation par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFormation(@PathVariable int id) {
        String response = formationService.deleteFormation(id);
        if (response.equals("Formation supprimé")) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    // Afficher les formations par catégorie
    @GetMapping("/categorie/{categorie}")
    public ResponseEntity<List<Formation>> getFormationsByCategorie(@PathVariable Formation.CategorieFormation categorie) {
        List<Formation> formations = formationService.afficherFormationsParCategorie(categorie);
        return new ResponseEntity<>(formations, HttpStatus.OK);
    }
}
