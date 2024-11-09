package com.example.msressources.Repository;
import com.example.msressources.entities.Equipement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipementRepository extends MongoRepository<Equipement, String> {
}
