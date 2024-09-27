package com.example.student.Services.Impl;

import com.example.student.Dto.EnrollmentDto;
import com.example.student.Mapper.EnrollmentMapper;
import com.example.student.Entities.Academician;
import com.example.student.Entities.Enrollment;
import com.example.student.Entities.Lesson;
import com.example.student.Entities.Student;
import com.example.student.Repositories.AcademicianRepository;
import com.example.student.ResponseMessage.Constants;
import com.example.student.ResponseMessage.GenericResponse;
import com.example.student.Repositories.LessonRepository;
import com.example.student.Repositories.EnrollmentRepository;
import com.example.student.Repositories.StudentRepository;
import com.example.student.Services.EnrollmentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentMapper enrollmentMapper;
    private final EnrollmentRepository enrollmentRepository;
    private final LessonRepository lessonRepository;
    private final StudentRepository studentRepository;
    private final AcademicianRepository academicianRepository;

    @Autowired
    public EnrollmentServiceImpl(EnrollmentMapper enrollmentMapper, EnrollmentRepository enrollmentRepository, LessonRepository lessonRepository, StudentRepository studentRepository, AcademicianRepository academicianRepository) {
        this.enrollmentMapper = enrollmentMapper;
        this.enrollmentRepository = enrollmentRepository;
        this.lessonRepository = lessonRepository;
        this.studentRepository = studentRepository;
        this.academicianRepository=academicianRepository;
    }
    public int findTotalCredit(List<Lesson> lessons){
        int totalCredit =0;
        for (Lesson l : lessons) {
            totalCredit +=l.getCourseCredit();
        }
        return totalCredit;
    }

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

            if(!lessons.contains(lesson) && (findTotalCredit(lessons)+lesson.getCourseCredit() <= 45)) {
                Enrollment enrollment = new Enrollment();
                 enrollment = enrollmentMapper.enrollmentDtoToEnrollment(enrollmentDto);
                //Enrollment enrollment= new Enrollment();

                enrollment.setStudentId(enrollmentDto.getStudentId());
                enrollment.setLessonId(enrollmentDto.getLessonId());
                enrollment.setCourseCredit(lesson.getCourseCredit());
                enrollment.setStudentName(student.getName() == null ? "" : student.getName());
                enrollment.setStudentSurname(student.getSurname() == null ? "" : student.getSurname());
                enrollmentRepository.save(enrollment);

                return GenericResponse.success(enrollment);

            } else {
                if (lessons.contains(lesson)){ return GenericResponse.error(Constants.FOUND_LESSON);}
                else {return GenericResponse.error(Constants.OVERFLOW_CREDIT);}
            }
        }


    }

    @Override
    public GenericResponse<?> getLessonList(Integer id){
        Academician academician = academicianRepository.findAcademicianById(id);
        List<Lesson> lessons= academician.getLessonList();
        if(lessons.isEmpty()){
            return GenericResponse.error(Constants.EMPTY_LIST);
        }else{
            return GenericResponse.success(lessons);
        }
    }

    @Override
    public GenericResponse<?> getAllEnrollment(Integer id) {
        Lesson lesson = lessonRepository.findById(id).orElse(null);
        List<Student> students= lesson.getStudentList();
        if(students.isEmpty()){
            return GenericResponse.error(Constants.EMPTY_LIST);
        } else {
            return GenericResponse.success(students);}
    }
    @Override
    public GenericResponse<?> enrollmentApproval(Integer id, Integer academicianId) {      //çalışmıyor
        // Find the enrollment by ID
        Enrollment enrollment = enrollmentRepository.findEnrollmentById(id);
        if (enrollment == null) {
            return GenericResponse.error(Constants.EMPTY_ENROLLMENT);
        }

        Lesson lesson = lessonRepository.findById(enrollment.getLessonId()).orElse(null);
        if (lesson == null || !lesson.getAcademist().getId().equals(academicianId)) {
            return GenericResponse.error(Constants.UNAUTHORIZED);
        }

        enrollment.setStatus(true);
        enrollmentRepository.save(enrollment);

        return GenericResponse.success(enrollment);
    }

    @Override
    public GenericResponse<?> enrollmentRefusal(Integer id, Integer academicianId) {    //çalışmıyor
        // Find the enrollment by ID
        Enrollment enrollment = enrollmentRepository.findEnrollmentById(id);
        if (enrollment == null) {
            return GenericResponse.error(Constants.EMPTY_ENROLLMENT);
        }

        Lesson lesson = lessonRepository.findById(enrollment.getLessonId()).orElse(null);
        if (lesson == null || !lesson.getAcademist().getId().equals(academicianId)) {
            return GenericResponse.error(Constants.UNAUTHORIZED);
        }

        enrollment.setStatus(false);
        enrollmentRepository.save(enrollment);

        return GenericResponse.success(enrollment);
    }

    @Override
    public GenericResponse<?> enrollmentListApproval (List<Integer> enrollmentIds, Integer academicianId) {
        List<Enrollment> approvedEnrollments = new ArrayList<>();

        for (Integer id : enrollmentIds) {
            Enrollment enrollment = enrollmentRepository.findEnrollmentById(id);
            if (enrollment == null) {
                GenericResponse.error(Constants.EMPTY_ENROLLMENT);
                continue;
            }

            Lesson lesson = lessonRepository.findById(enrollment.getLessonId()).orElse(null);
            if (lesson == null || !lesson.getAcademist().getId().equals(academicianId)) {
                GenericResponse.error(Constants.UNAUTHORIZED);
                continue;
            }

            enrollment.setStatus(true);
            approvedEnrollments.add(enrollment);
            enrollmentRepository.save(enrollment);
        }

        return GenericResponse.success(approvedEnrollments);
    }

    @Override
    public GenericResponse<?> enrollmentListRefusal(List<Integer> enrollmentIds, Integer academicianId) {
        List<Enrollment> approvedEnrollments = new ArrayList<>();

        for (Integer id : enrollmentIds) {
            Enrollment enrollment = enrollmentRepository.findEnrollmentById(id);
            if (enrollment == null) {
                GenericResponse.error(Constants.EMPTY_ENROLLMENT);
                continue;
            }

            Lesson lesson = lessonRepository.findById(enrollment.getLessonId()).orElse(null);
            if (lesson == null || !lesson.getAcademist().getId().equals(academicianId)) {
                GenericResponse.error(Constants.UNAUTHORIZED);
                continue;
            }

            enrollment.setStatus(false);
            approvedEnrollments.add(enrollment);
            enrollmentRepository.save(enrollment);
        }

        return GenericResponse.success(approvedEnrollments);
    }
}
