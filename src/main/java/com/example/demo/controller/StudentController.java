package com.example.demo.controller;
import org.springframework.beans.factory.annotation.*;
import java.util.*;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
@RestController()
@RequestMapping("/api/students")
public class StudentController{
    private final StudentService service;
   public StudentController(StudentService service){
        this.service = service;
    }
    
     @GetMapping()
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }
    
     @PostMapping()
    public Student addStudent(@RequestBody Student student){
        return service.addStudent(student);
    }
  
  @GetMapping("/ping")
public ResponseEntity<?> checkConnection() {
    return ResponseEntity.ok("Tong"); // no body
}

 @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id , @RequestBody Student student){
        return service.updateStudent(id,student);
    }
    @DeleteMapping("/{id}")
public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
    service.deleteStudent(id);
    return ResponseEntity.ok().build(); // no body
}
  }
