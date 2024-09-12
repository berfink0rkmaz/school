package com.example.student.Services.Impl;

import com.example.student.Entities.Student;
import com.example.student.Repositories.StudentRepository;
import com.example.student.ResponseMessage.Constants;
import com.example.student.ResponseMessage.GenericResponse;
import com.example.student.Services.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    @Override
    public GenericResponse<?> getAllStudents() {
        System.out.println("getAllStudents called");
        List<Student> students = studentRepository.findAll();
        if(students.isEmpty()) { return GenericResponse.error(Constants.EMPTY_LIST); }
        else{ return GenericResponse.success(students); }
    }

    @Override
    public GenericResponse<?> saveStudent(Student student) {
        System.out.println("save student called...");
        Student studentExists = studentRepository.findStudentById(student.getId());
        if (studentExists == null) {
            studentRepository.save(student);
            return GenericResponse.success(student);
        }else{
            return GenericResponse.error(Constants.FOUND_ID);
        }
    }
    @Override
    public GenericResponse<?> findById(Integer id) {
        System.out.println("getStudentById called");
        Student student = studentRepository.findStudentById(id);
        if (student==null) {
            return GenericResponse.error(Constants.EMPTY_ID);
        }else {
            return GenericResponse.success(student);
        }
    }

    @Override
    public GenericResponse<?> deleteStudent(Integer id) {
        System.out.println("delete student called...");
        Student studentExists = studentRepository.findStudentById(id);
        if(studentExists == null) {
            return GenericResponse.error(Constants.EMPTY_ID);
        }else {
            studentExists.setDeleted(true);
            studentRepository.save(studentExists);
            return GenericResponse.success(studentExists);
        }
    }

    @Override
    public GenericResponse<?> updateStudent(Student student) {
        System.out.println("update student called...");
        Student studentExists = studentRepository.findStudentById(student.getId());
        if (studentExists == null) {
            return GenericResponse.error(Constants.EMPTY_ID);
        }else {
            Student updatedStudent= studentRepository.save(student);
            return GenericResponse.success(updatedStudent);
        }
    }
   }
