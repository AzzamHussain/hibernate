package com.example.demo;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class student {
    @Id
    private int id;
    private String name;
    private String StudentClass;
    @Embedded
    private Marks studentMarks;  
    public int getid() {
        return id;       
        }
        public void setid(int id) {
        this.id = id;
        }
        public String getname() {
        return name;        
        }
        public void setname(String name) {
        this.name = name;
        }
        public String getStudentClass() {
        return StudentClass;        
        }
        public void setStudentClass(String StudentClass) {
        this.StudentClass = StudentClass;
        }
          public Marks getStudentMarks() {
        return studentMarks;
        }
        public void setStudentMarks(Marks studentMarks) {
        this.studentMarks = studentMarks;
        }
    }


