package com.example;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentDao dao;

    public StudentService(StudentDao dao) {
        this.dao = dao;
    }

    @PostConstruct
    public void init() {
        dao.ensureTable();
    }

    public void ensureTable() {
        dao.ensureTable();
    }

    public int addStudent(String name, int score) {
        return dao.insert(name, score);
    }

    public List<Student> listStudents() {
        return dao.findAll();
    }

    public int updateScore(String name, int score) {
        return dao.updateScoreByName(name, score);
    }

    public int deleteStudent(String name) {
        return dao.deleteByName(name);
    }

    public int deleteAll() {
        return dao.deleteAll();
    }
}
