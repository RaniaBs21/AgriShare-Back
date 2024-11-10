package com.example.msprojet.Controllers;

import com.example.msprojet.Entities.Partenariat;
import com.example.msprojet.Entities.Project;
import com.example.msprojet.Services.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("projet")
@AllArgsConstructor
public class ProjectController {

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
    @RequestMapping("/partenariats")
    public List<Partenariat> getAllPartenariat() {
        return projectService.getPartenariats();
    }
    @RequestMapping("partenariat/{id}")
    public Partenariat getPartenariatById(@PathVariable int id) {
        return projectService.getPartenariatById(id);
    }

    @GetMapping("/{id}/favorite-partenariat")
    public List<Partenariat> getFavoritePartenariat(@PathVariable String id) {
        return projectService.getFavoritePartenariat(id);
    }



    @PostMapping("/{id}/favorite-partenariat/{partenariatId}")
    public ResponseEntity<String> saveFavoriteJob(@PathVariable String id, @PathVariable int partenariatId) {
        Partenariat partenariat = projectService.getPartenariatById(partenariatId);
        if (partenariat != null) {
            projectService.saveFavoritePartenariat(id, partenariatId);
            return ResponseEntity.status(HttpStatus.OK).body("Partenariat saved as favorite successfully.");

        } else {
            // Gérer le cas où le job n'existe pas
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Partenariat not found with ID: " + partenariatId);
        }
    }

    /*@PostMapping(
            value = "/admin/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<Project> createProject(@RequestBody Project project , Authentication authentication) {

        try {
            Jwt jwt = (Jwt) authentication.getPrincipal();
            Map<String, Object> realmAccess = jwt.getClaimAsMap("realm_access");
            List<String> roles = (List<String>) realmAccess.get("roles");

            if (roles.contains("admin")) {
                return new ResponseEntity<>(projectService.addProject(project), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<List<Project>> getProject(){
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }*/






}
