package com.baeldung.ls.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectRepositoryInMemoryImpl implements IProjectRepository {

    private List<Project> projects = new ArrayList<>();

    public ProjectRepositoryInMemoryImpl() {
        super();
    }

    @Override
    public List<Project> getAll() {
        return projects;
    }
    
    @Override
    public Optional<Project> findById(Long id) {
        return projects.stream()
            .filter(p -> p.id().equals(id))
            .findFirst();
    }

    @Override
    public Project save(Project project) {
        Project existingProject = findById(project.id()).orElse(null);
        if (existingProject == null) {
            projects.add(project);
        } else {
            projects.remove(existingProject);
            Project newProject = new Project(project);
            projects.add(newProject);
        }
        return project;
    }

}
