package com.example.msprojet.Controllers;

import com.example.msprojet.Entities.Project;
import com.example.msprojet.Services.ProjectService;
import lombok.AllArgsConstructor;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
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

    @PostMapping
    @RequestMapping(value = "/admin/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Project> createProject(@RequestBody Project project, KeycloakAuthenticationToken auth) {
        KeycloakPrincipal<KeycloakSecurityContext> principal = (KeycloakPrincipal<KeycloakSecurityContext>) auth.getPrincipal();
        KeycloakSecurityContext context = principal.getKeycloakSecurityContext();
        boolean hasAdminRole = context.getToken().getRealmAccess().isUserInRole("admin");

        if (hasAdminRole) {
            System.out.println("Admin role recognized");
            return new ResponseEntity<>(projectService.addProject(project), HttpStatus.OK);
        } else {
            System.out.println("Admin role not recognized");
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }




    /*@PostMapping("/add")
    Project addProject(@RequestBody Project project ) {
        return  projectService.addProject(project);
    }*/

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
