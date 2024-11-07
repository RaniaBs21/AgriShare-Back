package com.example.msformation.Services;

import com.example.msformation.Entities.Test;
import com.example.msformation.Repositories.FormationRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TestService {
    FormationRepo testRepo ;
    public Test addTest(Test test) {
        return testRepo.save(test);
    }

    public List<Test> getAllTest() {
        return testRepo.findAll();
    }
}
