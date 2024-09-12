package com.example.student.Services;

import com.example.student.Entities.Student;
import com.example.student.ResponseMessage.GenericResponse;

public interface StudentService {
    GenericResponse<?> getAllStudents();
    GenericResponse<?> saveStudent(Student student);
    GenericResponse<?> findById(Integer id);
    GenericResponse<?> deleteStudent(Integer id);
    GenericResponse<?> updateStudent(Student student);
}
