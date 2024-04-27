package com.baeldung.ls.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baeldung.ls.persistence.IProjectRepository;
import com.baeldung.ls.persistence.ProjectRepositoryInMemoryImpl;

@Configuration
public class PersistenceConfig {

    @Bean
    IProjectRepository projectRepository() {
        return new ProjectRepositoryInMemoryImpl();
    }

}
