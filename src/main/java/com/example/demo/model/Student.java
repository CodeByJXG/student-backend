
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    @Column(name = "student_class") 
    private String studentClass;
    private String email;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getStudentClass() { return studentClass; }
    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}