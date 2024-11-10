package com.example.msprojet.Services;


import com.example.msprojet.Entities.Partenariat;
import com.example.msprojet.Entities.Project;
import com.example.msprojet.Repositories.PartenaritClient;
import com.example.msprojet.Repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    private PartenaritClient partenaritClient;


    public Project addProject(Project project) {
        return projectRepository.save(project);
    }
    public Optional<Project> updateProject(String id, Project projectDetails) {
        return projectRepository.findById(id).map(existingProject -> {
            existingProject.setNom(projectDetails.getNom());
            existingProject.setDescription(projectDetails.getDescription());
            existingProject.setDateDebut(projectDetails.getDateDebut());
            existingProject.setDateFin(projectDetails.getDateFin());
            existingProject.setEtapes(projectDetails.getEtapes());
            existingProject.setStatut(projectDetails.getStatut());
            return projectRepository.save(existingProject);
        });
    }
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
    public Optional<Project> getProjectById(String id) {
        return projectRepository.findById(id);
    }
    public void deleteProject(String id) {
        projectRepository.deleteById(id);
    }

    public List<Partenariat> getPartenariats() {
        return partenaritClient.getPartenariats();
    }

    public Partenariat getPartenariatById(int id) {
        return partenaritClient.getPartenariatById(id);
    }
    public List<Partenariat> getFavoritePartenariat(String projectId) {
        Project project = projectRepository.findById(projectId).get();
        return project.getFavoritePartenariat().stream()
                .map(partenaritClient::getPartenariatById)
                .collect(Collectors.toList());
    }


    public void saveFavoritePartenariat(String projectId, int partenariatId) {
        Project project = projectRepository.findById(projectId).get();
        project.getFavoritePartenariat().add(partenariatId);
        projectRepository.save(project);
    }
}
