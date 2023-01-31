package com.example.studentreportingsystem.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.studentreportingsystem.entity.Student;
import com.example.studentreportingsystem.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
}