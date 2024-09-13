package com.example.student.Services.Impl;

import com.example.student.Dto.EnrollmentDto;
import com.example.student.Dto.EnrollmentMapper;
import com.example.student.Entities.Enrollment;
import com.example.student.Entities.Lesson;
import com.example.student.Entities.Student;
import com.example.student.ResponseMessage.Constants;
import com.example.student.ResponseMessage.GenericResponse;
import com.example.student.Repositories.LessonRepository;
import com.example.student.Repositories.EnrollmentRepository;
import com.example.student.Repositories.StudentRepository;
import com.example.student.Services.EnrollmentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentMapper enrollmentMapper;
    private final EnrollmentRepository enrollmentRepository;
    private final LessonRepository lessonRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public EnrollmentServiceImpl(EnrollmentMapper enrollmentMapper, EnrollmentRepository enrollmentRepository, LessonRepository lessonRepository, StudentRepository studentRepository) {
        this.enrollmentMapper = enrollmentMapper;
        this.enrollmentRepository = enrollmentRepository;
        this.lessonRepository = lessonRepository;
        this.studentRepository = studentRepository;
    }
    public int findTotalCredit(List<Lesson> lessons){
        int totalCredit =0;
        for (Lesson l : lessons) {
            totalCredit +=l.getCourseCredit();
        }
        return totalCredit;
    }
    /*
    @Override
    public GenericResponse<?> getLessonsByDepartment(Integer studentId) {
        Student student = studentRepository.findStudentById(studentId);
        if (student == null) {
            return GenericResponse.error(Constants.EMPTY_STUDENT);
        }else{
            String department= student.getDepartment();
            List<Lesson> lessons = lessonRepository.findLessonByDepartment(department);
            return GenericResponse.success(lessons);
        }
    }
    */
    @Override
    public GenericResponse<?> saveEnrollment(EnrollmentDto enrollmentDto) {
        Student student = studentRepository.findById(enrollmentDto.getStudentId()).orElse(null);
        Lesson lesson= lessonRepository.findById(enrollmentDto.getLessonId()).orElse(null);
        if(student==null){
            return GenericResponse.error(Constants.EMPTY_STUDENT);
        }
        else if (lesson==null) {
            return GenericResponse.error(Constants.EMPTY_LESSON);
        }
        else{
            List<Lesson> lessons=student.getTakenLessons();

            if(!lessons.contains(enrollmentDto.getLessonId()) && (findTotalCredit(lessons)+lesson.getCourseCredit() <= 45)) {
                Enrollment enrollment = new Enrollment();
                enrollment.setStudentId(enrollmentDto.getStudentId());
                enrollment.setLessonId(enrollmentDto.getLessonId());
                enrollment.setCourseCredit(lesson.getCourseCredit());
                enrollment.setStudentName(student.getName() == null ? "" : student.getName());
                enrollment.setStudentSurname(student.getSurname() == null ? "" : student.getSurname());
                enrollmentRepository.save(enrollment);

                return GenericResponse.success(enrollment);

            } else {if (lessons.contains(enrollmentDto.getLessonId())) return GenericResponse.error(Constants.FOUND_LESSON);
            else return GenericResponse.error(Constants.OVERFLOW_CREDIT);}
        }


    }


}
