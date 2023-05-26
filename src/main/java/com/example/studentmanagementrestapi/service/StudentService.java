package com.example.studentmanagementrestapi.service;

import com.example.studentmanagementrestapi.entity.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);
    List<Student> getAllStudents();
    Student getStudent(Long id);
    Student updateStudent(Student student);
    void deleteStudent(Long id);
}
