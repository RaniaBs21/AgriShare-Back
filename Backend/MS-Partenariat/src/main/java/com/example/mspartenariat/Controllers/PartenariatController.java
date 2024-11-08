package com.example.mspartenariat.Controllers;

import com.example.mspartenariat.Entities.Partenariat;
import com.example.mspartenariat.Services.PartenariatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("partenariat")
@AllArgsConstructor
public class PartenariatController {
    @Autowired
    private PartenariatService partenariatService;

    // Créer un partenariat
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Partenariat> createPartenariat(@RequestBody Partenariat partenariat) {
        return new ResponseEntity<>(partenariatService.addPartenariat(partenariat), HttpStatus.CREATED);
    }

    // Récupérer tous les partenariats
    @GetMapping
    public ResponseEntity<List<Partenariat>> getPartenariats() {
        return new ResponseEntity<>(partenariatService.getAll(), HttpStatus.OK);
    }

    // Supprimer un partenariat par ID
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePartenariat(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(partenariatService.deletePartenariat(id), HttpStatus.OK);
    }

    // Mettre à jour un partenariat
    @PutMapping(value = "/update")
    public ResponseEntity<String> updatePartenariat(@RequestParam int id,
                                                    @RequestParam String email,
                                                    @RequestParam String nom,
                                                    @RequestParam String prenom,
                                                    @RequestParam String numeroTelephone) {
        partenariatService.updatePartenariat(id, email, nom, prenom, numeroTelephone);
        return new ResponseEntity<>("Partenariat mis à jour avec succès", HttpStatus.OK);
    }

    // Rechercher un partenariat par ID ou email
    @GetMapping(value = "/byIdOrEmail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Partenariat> getPartenariatByIdOrEmail(@RequestParam(required = false) Integer id,
                                                                 @RequestParam(required = false) String email) {
        if (id != null) {
            return new ResponseEntity<>(partenariatService.findPartenariatByIdOrEmail(id, null), HttpStatus.OK);
        } else if (email != null) {
            return new ResponseEntity<>(partenariatService.findPartenariatByIdOrEmail(0, email), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
