package com.example.student.Controllers;

import com.example.student.Entities.Student;
import com.example.student.ResponseMessage.Constants;
import com.example.student.ResponseMessage.GenericResponse;
import com.example.student.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAll")
    public GenericResponse<?> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/save")
    public GenericResponse<?> createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/find-By-Id")
    public GenericResponse<?> getStudentById(@RequestParam Integer id) {
        return studentService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public GenericResponse<?> deleteStudent(@PathVariable Integer id) {
        return studentService.deleteStudent(id);
    }

    @PutMapping ("/update")
    public GenericResponse<?> updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }
}
