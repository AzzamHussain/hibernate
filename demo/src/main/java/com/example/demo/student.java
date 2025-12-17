package com.example.demo;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    // Agar tum manually id set karna chahte ho to is line ko hata sakte ho
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(name = "student_class")
    private String studentClass;

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<StudentMarks> marksList = new ArrayList<>();

    /* ---------------- Getters & Setters ---------------- */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    /* ---------------- Helper Methods (IMPORTANT) ---------------- */

    public void addMark(StudentMarks mark) {
        marksList.add(mark);
        mark.setStudent(this);
    }

    public void removeMark(StudentMarks mark) {
        marksList.remove(mark);
        mark.setStudent(null);
    }
}
