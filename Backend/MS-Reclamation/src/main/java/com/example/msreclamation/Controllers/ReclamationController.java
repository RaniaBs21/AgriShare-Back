package com.example.msreclamation.Controllers;

import com.example.msreclamation.Entities.Reclamation;
import com.example.msreclamation.Services.IReclamationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reclamation")
@AllArgsConstructor
public class ReclamationController {
    @Autowired
    private IReclamationService reclamationService;

    // Récupère la liste de toutes les réclamations
    @GetMapping("/getAllReclamation")
    public List<Reclamation> getAllReclamations() {
        return reclamationService.getAllReclamations();
    }

    @PostMapping("/addReclamation")
    public ResponseEntity<?> addReclamation(@RequestBody Reclamation reclamation) {

        // Utilisation d'un idMembre statique temporaire
        Long idMembreStatique = 1L; // ID de membre fixe

        try {
            // Assigner l'idMembre statique à la réclamation
            reclamation.setIdMembre(idMembreStatique);

            Reclamation newReclamation = reclamationService.addReclamation(reclamation);
            return ResponseEntity.status(HttpStatus.CREATED).body(newReclamation);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while creating reclamation");
        }
    }

    // Récupère une réclamation spécifique par son ID
    @GetMapping("/getReclamationById/{id}")
    public ResponseEntity<Reclamation> getReclamationById(@PathVariable Long id) {
        Reclamation reclamation = reclamationService.getReclamationById(id);
        return ResponseEntity.ok(reclamation);
    }
}
