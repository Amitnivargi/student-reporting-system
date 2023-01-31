package com.example.studentreportingsystem.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "marks")
@Getter
@Setter
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(name = "semester", nullable = false)
    private int semester;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "marks", nullable = false)
    private int marks;
}