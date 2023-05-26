package com.example.studentmanagementrestapi.controller;

import com.example.studentmanagementrestapi.entity.Student;
import com.example.studentmanagementrestapi.service.StudentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student newStudent = studentService.addStudent(student);
        return ResponseEntity.ok(newStudent);
    }


    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student student = studentService.getStudent(id);
        if(student != null){
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updateStudent){
        Student student = studentService.getStudent(id);
        if (student == null){
            return ResponseEntity.notFound().build();
        } else {
            student.setFirstName(updateStudent.getFirstName());
            student.setLastName(updateStudent.getLastName());
            student.setAddress(updateStudent.getAddress());
            student.setEmail(updateStudent.getEmail());
            student.setDateOfBirth(updateStudent.getDateOfBirth());
            student.setPhoneNumber(updateStudent.getPhoneNumber());

            Student updatedStudent = studentService.updateStudent(student);

            return ResponseEntity.ok(updatedStudent);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        if (studentService.getStudent(id) != null){
            studentService.deleteStudent(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
