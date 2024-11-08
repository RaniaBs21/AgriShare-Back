package com.example.msformation.Repositories;

import com.example.msformation.Entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FormationRepo extends JpaRepository<Formation, Integer> {
    List<Formation> findByCategorie(Formation.CategorieFormation categorie);
}
