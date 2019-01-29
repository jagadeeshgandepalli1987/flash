package com.zetcode.conf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConf {

    @Bean
//    @Qualifier(value = "em")
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }
    
    @Bean
    public EntityManagerFactory createEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("cars-pu");
    }
}
