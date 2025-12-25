package com.example.demo.controller;
import org.springframework.beans.factory.annotation.*;
import java.util.*;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
@RestController()
public class StudentController{
    private final String address = "/api/students";
    private final StudentService service;
    StudentController(StudentService service){
        this.service = service;
    }
    
     @RequestMapping(value = address,method = RequestMethod.GET)
    private List<Student> getAllStudents(){
        return service.getAllStudents();
    }
    
     @RequestMapping(value = address,method = RequestMethod.POST)
    private Student addStudent(@RequestBody Student student){
        return service.addStudent(student);
    }
  
  @RequestMapping(value="/api/ping")
public ResponseEntity<?> checkConnection() {
    return ResponseEntity.ok("Tong"); // no body
}

 @RequestMapping(value=address+"/{id}",method=RequestMethod.PUT)
    private Student addStudent(@PathVariable Long id , @RequestBody Student student){
        return service.updateStudent(id,student);
    }
    @RequestMapping(value = address+"/{id}",method = RequestMethod.DELETE)
public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
    service.deleteStudent(id);
    return ResponseEntity.ok().build(); // no body
}
  }
