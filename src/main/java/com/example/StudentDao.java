package com.example;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class StudentDao {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Student> rowMapper = (ResultSet rs, int rowNum) ->
            new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("score"));

    public StudentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void ensureTable() {
        jdbcTemplate.execute(
                "CREATE TABLE IF NOT EXISTS student (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "name TEXT NOT NULL," +
                        "score INTEGER NOT NULL" +
                        ")"
        );
    }

    public int insert(String name, int score) {
        return jdbcTemplate.update(
                "INSERT INTO student(name, score) VALUES(?, ?)", name, score);
    }

    public List<Student> findAll() {
        return jdbcTemplate.query("SELECT id, name, score FROM student", rowMapper);
    }

    public int updateScoreByName(String name, int score) {
        return jdbcTemplate.update(
                "UPDATE student SET score = ? WHERE name = ?", score, name);
    }

    public int deleteByName(String name) {
        return jdbcTemplate.update("DELETE FROM student WHERE name = ?", name);
    }

    public int deleteAll() {
        return jdbcTemplate.update("DELETE FROM student");
    }
}
