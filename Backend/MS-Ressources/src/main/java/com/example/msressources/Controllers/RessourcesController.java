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

    @PostMapping( "/addEquipements")

    public Equipement ajouterEquipement(@RequestBody Equipement equipement) {

        return ressourcesService.ajouterEquipement(equipement);

    }
    @GetMapping
    public List<Equipement> getEquipement() {
        return ressourcesService.getAllEquipements();
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

    @GetMapping
    List<Ressources> getRessources(){
        return ressourcesService.getAllRessources();
    }

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
