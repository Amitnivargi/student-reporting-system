package com.example.studentreportingsystem.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentreportingsystem.entity.Marks;
import com.example.studentreportingsystem.repository.MarksRepository;
import com.example.studentreportingsystem.entity.Student;
import com.example.studentreportingsystem.repository.StudentRepository;

@Service
public class MarksService {

    @Autowired
    private MarksRepository marksRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Marks addMarks(Marks marks) {
        return marksRepository.save(marks);
    }

    public double getAveragePercentageOfWholeClass(int recentSemester) {
        List<Marks> marks = marksRepository.findBySemester(recentSemester);
        int totalMarks = marks.stream().mapToInt(Marks::getMarks).sum();
        int totalStudents = marks.stream().map(Marks::getStudent).distinct().collect(Collectors.toList()).size();
        return (totalMarks / (totalStudents * 3.0)) * 100;
    }

    public double getAverageMarksBySubject(String subject) {
        List<Marks> marks = marksRepository.findBySubject(subject);
        int totalMarks = marks.stream().mapToInt(Marks::getMarks).sum();
        int totalStudents = marks.stream().map(Marks::getStudent).distinct().collect(Collectors.toList()).size();
        return totalMarks / (totalStudents * 1.0);
    }

    public List<Student> getTopTwoConsistentStudents() {
        List<Student> allStudents = studentRepository.findAll();
        allStudents.forEach(student -> {
            List<Marks> marks = marksRepository.findByStudentId(student.getId());
            double totalMarks = 0;
            int count = 0;
            for (Marks mark : marks) {
                totalMarks += mark.getMarks();
                count++;
            }
            student.setAverageMarks(totalMarks / count);
        });
        allStudents.sort((s1, s2) -> Double.compare(s2.getAverageMarks(), s1.getAverageMarks()));
        return allStudents.subList(0, 2);
    }
}