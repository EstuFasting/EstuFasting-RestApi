package edu.estu.estufastingrestapi.core.repository.config;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration
@RequiredArgsConstructor
public class HibernateConfig {

    private final DataSource dataSource;
    private final EntityManager entityManager;

    @Bean
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Bean
    public Session getSession() {
        return entityManager.unwrap(Session.class);
    }

}
