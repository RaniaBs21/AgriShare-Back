package com.example.msprojet.Controllers;

import com.example.msprojet.Entities.Project;
import com.example.msprojet.Services.ProjectService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("projet")
@AllArgsConstructor
public class ProjetController {
    ProjectService projectService;


    @PostMapping("/add")
    Project addProject(@RequestBody Project project ) {
        return  projectService.addProject(project);
    }


    @GetMapping("/all")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable String id) {
        return projectService.getProjectById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable String id, @RequestBody Project projectDetails) {
        Optional<Project> updatedProject = projectService.updateProject(id, projectDetails);
        return updatedProject.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable String id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
