package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {
    @Bean
    public DataSource dataSource(@Value("${DATABASE_URL}") String databaseUrl) {
        String url = databaseUrl;
        if (url != null && !url.startsWith("jdbc:")) {
            url = "jdbc:" + url;
        }
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(url);
        ds.setDriverClassName("org.postgresql.Driver");
        return ds;
    }
}
