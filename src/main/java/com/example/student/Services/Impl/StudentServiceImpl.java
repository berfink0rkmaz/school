package com.example.student.Services.Impl;

import com.example.student.Constants;
import com.example.student.Entities.Lessons;
import com.example.student.Entities.Students;
import com.example.student.GenericResponse;
import com.example.student.Repositories.StudentRepository;
import com.example.student.Services.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }
    @Override
    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Students saveStudent(Students student) {

        return studentRepository.save(student);
    }

    @Override
    public Students findByTcNo(String tcNo) {
        return studentRepository.findByTcNo(tcNo);
    }
    @Override
    public void deleteStudent(Students student) {
        student.setDeleted(true);
       // List<Lessons> lessons = student.getSelects();
       // lessons.forEach(lesson -> {
           // System.out.println(lesson.getAdi());
       // });
        studentRepository.save(student);
    }

    @Override
    public Students updateStudent(Students student) {

        return studentRepository.save(student);
    }
    @Override
    public Optional<Students> findById(Integer id) {
        return studentRepository.findById(id);
    }
}
