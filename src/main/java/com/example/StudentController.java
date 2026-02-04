package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public Student create(@RequestBody StudentCreateRequest req) throws Exception {
        service.addStudent(req.getName(), req.getScore());
        return new Student(0, req.getName(), req.getScore());
    }

    @GetMapping
    public List<Student> list() throws Exception {
        return service.listStudents();
    }

    @PutMapping("/{name}")
    public String update(@PathVariable String name, @RequestBody StudentUpdateRequest req) throws Exception {
        int rows = service.updateScore(name, req.getScore());
        return rows > 0 ? "updated" : "not_found";
    }

    @DeleteMapping("/{name}")
    public String delete(@PathVariable String name) throws Exception {
        int rows = service.deleteStudent(name);
        return rows > 0 ? "deleted" : "not_found";
    }

    @DeleteMapping
    public String deleteAll() throws Exception {
        int rows = service.deleteAll();
        return rows > 0 ? "deleted_all" : "empty";
    }
}
