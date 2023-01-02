package com.nelson.microservices.repository;

import com.nelson.microservices.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
