package com.example.msressources.Controllers;


import com.example.msressources.entities.Equipement;
import com.example.msressources.entities.Ressources;
import com.example.msressources.services.RessourcesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("ressources")
@AllArgsConstructor
public class RessourcesController {
    RessourcesService ressourcesService;

    @PostMapping( value = "/addEquipements",  consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<Equipement> ajouterEquipement(@RequestBody Equipement equipement, Authentication authentication) {
        try {
            Jwt jwt = (Jwt) authentication.getPrincipal();
            Map<String, Object> realmAccess = jwt.getClaimAsMap("realm_access");
            List<String> roles = (List<String>) realmAccess.get("roles");
            if (roles.contains("admin")) {
            return new ResponseEntity<>(ressourcesService.ajouterEquipement(equipement), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public ResponseEntity<List<Equipement>> getEquipement() {
        return new ResponseEntity<>(ressourcesService.getAllEquipements(), HttpStatus.OK);
    }


    @GetMapping("/getEquipement/{id}")
    public Equipement getEquipementById(@PathVariable String id) {
        return ressourcesService.getEquipementById(id);
    }

    @DeleteMapping("/deleteEquipement/{id}")
    public void deleteEquipement(@PathVariable String id) {
        ressourcesService.deleteEquipements(id);
    }

    @PutMapping("/updateEquipement/{id}")
    public Equipement updateEquipement(@PathVariable String id, @RequestBody Equipement equipement) {
        return ressourcesService.updateEquipement(equipement, id);

    }


    //ressources


  @PostMapping("/addRessource")
    public Ressources ajouterRessource(@RequestBody Ressources ressource) {
        return ressourcesService.ajouterRessource(ressource);
    }

//    @GetMapping()
//    List<Ressources> getRessources(){
//        return ressourcesService.getAllRessources();
//    }

    @GetMapping("/getRessource/{id}")
    public Ressources getRessourceById(@PathVariable String id) {
        return ressourcesService.getRessourceById(id);
    }

    @DeleteMapping("/deleteRessource/{id}")
    public void deleteRessources(@PathVariable String id) {
        ressourcesService.deleteRessources(id);
    }

    @PutMapping("/updateRessource/{id}")
    public Ressources updateressources(@PathVariable String id, @RequestBody Ressources ressources) {
        return ressourcesService.updateRessources(ressources, id);

    }




}
