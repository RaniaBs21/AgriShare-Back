package com.example.mspartenariat.Repositories;

import com.example.mspartenariat.Entities.Partenariat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PartenariatRepository extends JpaRepository<Partenariat, Integer> {
    Optional<Partenariat> findByEmail(String email);
}
