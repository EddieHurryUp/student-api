package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import org.sqlite.SQLiteDataSource;

@Configuration
public class DatabaseConfig {
    @Bean
    public DataSource dataSource(@Value("${app.db.path}") String dbPath) {
        SQLiteDataSource ds = new SQLiteDataSource();
        ds.setUrl("jdbc:sqlite:" + dbPath);
        return ds;
    }
}
