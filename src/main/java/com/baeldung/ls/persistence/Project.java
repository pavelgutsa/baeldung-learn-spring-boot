package com.baeldung.ls.persistence;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public record Project(Long id, String name, LocalDate dateCreated) {

    public Project {
        if(Objects.isNull(id)) {
            id = new Random().nextLong();
        }
    }

    public Project(Project project) {
        this(project.id(), project.name(), project.dateCreated());
    }
}
