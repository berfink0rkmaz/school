package com.example.student.Services;

import com.example.student.Entities.Lessons;
import com.example.student.Entities.Students;

import java.util.List;

public interface StudentService {
    Students saveStudent(Students student);
    List<Students> getAllStudents();

}
