package com.example.msformation.Services;

import com.example.msformation.Entities.Formation;
import com.example.msformation.Repositories.FormationRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FormationService {
    @Autowired
    private FormationRepo formationRepository ;

    public Formation addFormation(Formation formation){return formationRepository.save(formation);}
    public List<Formation> getAllFormation(){return formationRepository.findAll();}

    public void updateFormation(Integer   id, Formation updatedFormation) {
        Formation formation = formationRepository.findById(id).orElse(null);

        if (formation != null) {
            // Mettez à jour les champs avec les valeurs de updatedFormation
            formation.setTitre(updatedFormation.getTitre());
            formation.setDescription(updatedFormation.getDescription());
            formation.setDate(updatedFormation.getDate());
            formation.setType(updatedFormation.getType());
            formation.setCategorie(updatedFormation.getCategorie());

            // Sauvegarde des modifications
            formationRepository.save(formation);
        } else {
            // Gérer le cas où la formation n'est pas trouvée
            throw new EntityNotFoundException("Formation avec l'ID " + id + " non trouvée");
        }
    }

    public String deleteFormation ( int id){
        if (formationRepository.findById(id).isPresent()) {
            formationRepository.deleteById(id);
            return "Formation supprimé";
        } else
            return "Formation  non supprimé";
    }

    public List<Formation> afficherFormationsParCategorie(Formation.CategorieFormation categorie) {
        return formationRepository.findByCategorie(categorie);
    }

}
