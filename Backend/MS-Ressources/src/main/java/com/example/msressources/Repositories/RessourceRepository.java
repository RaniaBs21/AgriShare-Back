package com.example.msressources.Repositories;

import com.example.msressources.Entities.Ressources;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RessourceRepository extends MongoRepository<Ressources, String> {

}
