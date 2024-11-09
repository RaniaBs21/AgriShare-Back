package com.example.msressources.Repositories;

import com.example.msressources.Entities.Equipement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipementRepository extends MongoRepository<Equipement, String> {
}
