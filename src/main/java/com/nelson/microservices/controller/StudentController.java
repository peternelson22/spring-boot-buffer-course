package com.nelson.microservices.controller;

import com.nelson.microservices.entity.Student;
import com.nelson.microservices.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/save")
    public Student save(@RequestBody Student student){
        return studentService.saveStudent(student);
    }
    @GetMapping("/")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudent(@PathVariable Long id){
        return studentService.getStudent(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Long id){
        return studentService.updateStudent(student, id);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "successfully deleted";
    }
}
