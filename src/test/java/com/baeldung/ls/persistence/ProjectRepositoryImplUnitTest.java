package com.baeldung.ls.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class ProjectRepositoryImplUnitTest {

    @Test
    void findById_givenDummyId_returnsEmpty() {
        assertFalse(new ProjectRepositoryInMemoryImpl().findById(123L).isPresent());
    }
    
    @Test
    void findById_givenId_returnsProject() {
    	IProjectRepository repo = new ProjectRepositoryInMemoryImpl();
    	repo.save(new Project(123l, "Test project", LocalDate.now()));
        assertTrue(repo.findById(123l).isPresent());
        assertEquals("Test project", repo.findById(123l).get().name());
    }
    
    @Test
    void findById_givenNoId_returnsProject() {
    	IProjectRepository repo = new ProjectRepositoryInMemoryImpl();
    	repo.save(new Project(null, "Test project", LocalDate.now()));
        assertFalse(repo.getAll().isEmpty());
    }
}