package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(name = "student_class", nullable = false)
    private String studentClass;

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<StudentMarks> marksList = new ArrayList<>();

    // ---------------- Constructors ----------------

    public Student() {
    }

    // ---------------- Getters & Setters ----------------

    public int getId() {
        return id;
    }

    // ❌ setId() intentionally NOT added
    // Hibernate khud ID generate karega

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public List<StudentMarks> getMarksList() {
        return marksList;
    }

    public void setMarksList(List<StudentMarks> marksList) {
        this.marksList = marksList;
    }

    // ---------------- Helper Methods ----------------

    public void addMark(StudentMarks mark) {
        marksList.add(mark);
        mark.setStudent(this);
    }

    public void removeMark(StudentMarks mark) {
        marksList.remove(mark);
        mark.setStudent(null);
    }
}
