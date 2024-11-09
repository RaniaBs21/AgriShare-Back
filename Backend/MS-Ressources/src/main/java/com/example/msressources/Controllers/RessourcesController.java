package com.example.msressources.Controllers;

import com.example.msressources.Entities.Equipement;
import com.example.msressources.Entities.Ressources;
import com.example.msressources.Services.RessourcesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ressources")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class RessourcesController {
    RessourcesService ressourcesService;

    @PostMapping( "/addEquipements")

    public Equipement ajouterEquipement(@RequestBody Equipement equipement) {

        return ressourcesService.ajouterEquipement(equipement);

    }
    @GetMapping("/getEquipement")
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

    @GetMapping("/getRessources")
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
