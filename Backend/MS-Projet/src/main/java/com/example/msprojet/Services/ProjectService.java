package com.example.msprojet.Services;

import com.example.msprojet.Entities.Project;
import com.example.msprojet.Repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProjectService {
    ProjectRepository projectRepository;

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


}
