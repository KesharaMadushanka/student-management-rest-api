package com.example.studentmanagementrestapi.service;

import com.example.studentmanagementrestapi.entity.Student;
import com.example.studentmanagementrestapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepo;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepo = studentRepository;
    }

    @Override
    //add students
    public Student addStudent(Student student) {
        studentRepo.save(student);
        return student;
    }

    @Override
    //return all students
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    //return a student
    public Student getStudent(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
    //update a student
    public Student updateStudent(Student student) {
        return studentRepo.save(student);
    }

    //delete a student
    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }
}
