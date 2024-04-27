package com.baeldung.ls.persistence;

import java.util.List;
import java.util.Optional;

public interface IProjectRepository {

	List<Project> getAll();
	
    Optional<Project> findById(Long id);

    Project save(Project project);
}
