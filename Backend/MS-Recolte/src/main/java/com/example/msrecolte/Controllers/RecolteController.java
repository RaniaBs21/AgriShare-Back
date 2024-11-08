package com.example.msrecolte.Controllers;

import com.example.msrecolte.entities.recolte;
import com.example.msrecolte.services.RecolteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("recolte")
@AllArgsConstructor
public class RecolteController {

    private RecolteService recolteService;

    @PostMapping
    public recolte ajouterRecolte(@RequestBody recolte recolte) {
        return recolteService.ajouterRecolte(recolte);
    }

    @PutMapping("/{id}")
    public recolte modifierRecolte(@PathVariable String id, @RequestBody recolte recolte) {
        return recolteService.modifierRecolte(id, recolte);
    }

    @DeleteMapping("/{id}")
    public void supprimerRecolte(@PathVariable String id) {
        recolteService.supprimerRecolte(id);
    }



    @GetMapping("/{id}")
    public recolte obtenirRecolteParId(@PathVariable String id) {
        return recolteService.obtenirRecolteParId(id);
    }
    @GetMapping("/AllRecoltes")
    public List<recolte> obtenirRecoltes() {
        return recolteService.obtenirRecoltes();
    }

    @GetMapping("/types-culture")
    public List<String> getTypesCulture() {
        return Arrays.asList("Blé", "Maïs", "Riz", "Soja", "Tomate");
    }

    @GetMapping("/types-culture/{typeCulture}")
    public List<recolte> listerRecoltesParTypeCulture(@PathVariable String typeCulture) {
        return recolteService.listerRecoltesParTypeCulture(typeCulture);
    }
}
