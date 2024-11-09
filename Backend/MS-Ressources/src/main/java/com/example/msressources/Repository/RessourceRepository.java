package com.example.msressources.Repository;


import com.example.msressources.entities.Ressources;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RessourceRepository extends MongoRepository<Ressources, String> {

}
