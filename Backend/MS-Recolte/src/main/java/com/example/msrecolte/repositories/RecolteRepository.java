package com.example.msrecolte.repositories;
import com.example.msrecolte.entities.recolte;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RecolteRepository extends MongoRepository<recolte,String>{

        List<recolte> findByTypeCulture(String typeCulture);

}
