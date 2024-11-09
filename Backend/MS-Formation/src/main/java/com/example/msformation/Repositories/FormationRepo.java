package com.example.msformation.Repositories;

import com.example.msformation.Entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepo extends JpaRepository<Test, Integer> {
}
