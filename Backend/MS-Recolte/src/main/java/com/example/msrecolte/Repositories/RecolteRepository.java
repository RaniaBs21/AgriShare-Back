package com.example.msrecolte.Repositories;

import com.example.msrecolte.Entities.recolte;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecolteRepository extends MongoRepository<recolte,String> {

    List<recolte> findByTypeCulture(String typeCulture);

}
