package com.example.msreclamation.Services;

import com.example.msreclamation.Entities.Reclamation;
import com.example.msreclamation.Repositories.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReclamationServiceImpl implements IReclamationService{

    @Autowired
    private ReclamationRepository reclamationRepository;

    @Override
    public Reclamation addReclamation(Reclamation reclamation) {
        reclamation.setDateSoumission(LocalDate.now()); // Définir la date de soumission
        return reclamationRepository.save(reclamation);
    }

    @Override
    public Reclamation getReclamationById(Long id) {
        return reclamationRepository.findById(id).orElse(null);
    }



    @Override
    public List<Reclamation> getAllReclamations() {
        return reclamationRepository.findAll();
    }


    @Override
    public void deleteReclamation(Long id) {
        reclamationRepository.deleteById(id);
    }
}
