package com.example.demo.service;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
@Service
public class StudentService{
    private final StudentRepository repo;
    StudentService(StudentRepository repo){
        this.repo = repo;
    }
    public List<Student> getAllStudents(){
        return repo.findAll();
    }
    
    public Student addStudent(Student student){
        return repo.save(student);
    }
    
    public Student updateStudent(Long id,Student st){
        Student student = repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setName(st.getName());
        student.setAge(st.getAge());
        student.setStudentClass(st.getStudentClass());
        student.setEmail(st.getEmail());
        
        return repo.save(student);
    }
    public void deleteStudent(Long id){
        repo.deleteById(id);
    }
    
}