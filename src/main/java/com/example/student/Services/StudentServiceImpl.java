package com.example.student.Services;

import com.example.student.Entities.Lessons;
import com.example.student.Entities.Students;
import com.example.student.Repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }
    @Override
    public Students saveStudent(Students student) {

        return studentRepository.save(student);
    }
    @Override
    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }
}
