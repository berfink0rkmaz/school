package com.example.student.Services;

import com.example.student.Entities.Academisions;
import com.example.student.Entities.Lessons;
import com.example.student.Entities.Students;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Students saveStudent(Students student);
    List<Students> getAllStudents();
    Students findByTcNo(String tcNo);
    void deleteStudent(Students student);
    Students updateStudent(Students student);
    Optional<Students> findById(Integer id);
}
