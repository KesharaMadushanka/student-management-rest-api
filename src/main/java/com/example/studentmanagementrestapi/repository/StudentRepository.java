package com.example.studentmanagementrestapi.repository;

import com.example.studentmanagementrestapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student, Long> {

}
