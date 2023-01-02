package com.nelson.microservices.service;

import com.nelson.microservices.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getStudents();

    Optional<Student> getStudent(Long id);

    Student updateStudent(Student student, Long id);

    void deleteStudent(Long id);
}
