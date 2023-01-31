package com.example.studentreportingsystem.repository;


import com.example.studentreportingsystem.entity.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MarksRepository extends JpaRepository<Marks, Integer> {
    List<Marks> findBySemester(int semester);
    List<Marks> findBySubject(String subject);
    List<Marks> findByStudentId(long studentId);
}