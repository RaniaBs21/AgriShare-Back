package com.example.msreclamation.Repositories;

import com.example.msreclamation.Entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ReclamationRepository extends JpaRepository<Reclamation,Long> {
}
