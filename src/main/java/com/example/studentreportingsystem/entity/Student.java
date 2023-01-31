package com.example.studentreportingsystem.entity;

//package com.example.studentreportingsystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "roll_no", nullable = false)
    private String rollNo;

    @OneToMany(mappedBy = "student")
    private List<Marks> marks;

    @Column(name = "average_marks")
    private double averageMarks;
    public void setAverageMarks(double averageMarks) {
        this.averageMarks = averageMarks;
    }
}
//    @Column(name = "student_name")
//    private String studentName;
//
//    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
//    private List<Marks> marks;