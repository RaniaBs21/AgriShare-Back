package com.example.msformation.Controllers;

import com.example.msformation.Entities.Test;
import com.example.msformation.Services.TestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("formation")
@AllArgsConstructor
public class FormationController {
    TestService testService;

    @PostMapping
    public ResponseEntity<Test> createTest(@RequestBody Test  test) {
        return new ResponseEntity<>(testService.addTest(test), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Test>> getTests() {
        return new ResponseEntity<>(testService.getAllTest(), HttpStatus.OK);
    }
}
