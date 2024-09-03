package com.example.student.Controllers;

import com.example.student.Entities.Lessons;
import com.example.student.Entities.Students;
import com.example.student.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllStudents() {
        System.out.println("getAllStudents called");
        List<Students> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping("/findByTcNo")
    public ResponseEntity<?> getStudentByTcNo(@RequestParam String tcNo) {
        System.out.println("getStudentByTcNo called");
        Students student= studentService.findByTcNo(tcNo);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    @PostMapping("/save")
    public Students createOgrenci (@RequestBody Students students) {
        System.out.println("save student called...");
        return studentService.saveStudent(students);
    }
    @DeleteMapping
    public void deleteStudent(@RequestBody Students student) {
        System.out.println("delete student called...");
        studentService.deleteStudent(student);
    }
}
