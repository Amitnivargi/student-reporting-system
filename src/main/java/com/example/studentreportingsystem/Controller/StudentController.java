package com.example.studentreportingsystem.Controller;

import java.util.List;

import com.example.studentreportingsystem.entity.Marks;
import com.example.studentreportingsystem.services.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.studentreportingsystem.entity.Student;
import com.example.studentreportingsystem.services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private MarksService marksService;

    @PostMapping("/add-student")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PostMapping("/add-marks")
    public Marks addMarks(@RequestBody Marks marks) {
        return marksService.addMarks(marks);
    }

    @GetMapping("/average-percentage-of-whole-class")
    public double getAveragePercentageOfWholeClass(@RequestParam int recentSemester) {
        return marksService.getAveragePercentageOfWholeClass(recentSemester);
    }

    @GetMapping("/average-marks-by-subject")
    public double getAverageMarksBySubject(@RequestParam String subject) {
        return marksService.getAverageMarksBySubject(subject);
    }

    @GetMapping("/top-two-consistent-students")
    public List<Student> getTopTwoConsistentStudents() {
        return marksService.getTopTwoConsistentStudents();
    }
}
