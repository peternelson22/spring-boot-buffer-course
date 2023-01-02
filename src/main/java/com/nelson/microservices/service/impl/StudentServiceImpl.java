package com.nelson.microservices.service.impl;

import com.nelson.microservices.entity.Student;
import com.nelson.microservices.exception.StudentNotFoundException;
import com.nelson.microservices.repository.StudentRepository;
import com.nelson.microservices.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        Student stu = Student.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .country(student.getCountry())
                .build();

        return studentRepository.save(stu);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudent(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(RuntimeException::new);

            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setCountry(student.getCountry());

        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() ->
                new StudentNotFoundException("Student with id  " + id + " not found"));
        studentRepository.deleteById(id);
    }
}
