package com.example.student.Controllers;

import com.example.student.Constants;
import com.example.student.Entities.Students;
import com.example.student.GenericResponse;
import com.example.student.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public GenericResponse<?> getAllStudents() {
        System.out.println("getAllStudents called");
        List<Students> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            return GenericResponse.error(Constants.EMPTY_LIST);
        }else{
            return GenericResponse.success(students);
        }
    }
    @GetMapping("/find-By-TcNo")
    public GenericResponse<?> getStudentByTcNo(@RequestParam String tcNo) {
        System.out.println("getStudentByTcNo called");
        Students student= studentService.findByTcNo(tcNo);
        if (student == null) {
            return GenericResponse.error(Constants.EMPTY_TCNO);
        }else {
            return GenericResponse.success(student);
        }
    }
    @PostMapping("/save")
    public GenericResponse<?> createOgrenci (@RequestBody Students student) {
        System.out.println("save student called...");
        Students studentExists = studentService.findByTcNo(student.getTcNo());
        if (studentExists == null) {
            studentService.saveStudent(student);
            return GenericResponse.success(student);
        }else{
            return GenericResponse.error(Constants.FOUND_TCNO);
        }
    }
    @DeleteMapping("/delete")
    public GenericResponse<?> deleteStudent(@RequestBody Students student) {
        System.out.println("delete student called...");
        Students studentExists = studentService.findByTcNo(student.getTcNo());
        if (studentExists == null) {
            return GenericResponse.error(Constants.EMPTY_TCNO);
        }else{
            studentService.deleteStudent(studentExists);
            return GenericResponse.success(studentExists);
        }
    }
    @PutMapping ("/update")
    public GenericResponse<?> updateStudent(@RequestBody Students student) {
        System.out.println("update student called...");
        Students studentExists = studentService.findByTcNo(student.getTcNo());
        if (studentExists == null) {
            return GenericResponse.error(Constants.EMPTY_TCNO);
        }else {
           Students updatedStudent= studentService.updateStudent(student);
           return GenericResponse.success(updatedStudent);
        }
    }
}
