package com.example.student.Services;

import com.example.student.Dto.EnrollmentDto;
//import com.example.student.Entities.Enrollment;
import com.example.student.ResponseMessage.GenericResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnrollmentService {
    //GenericResponse<?> getLessonsByDepartment(Integer studentId);
    GenericResponse<?> saveEnrollment(EnrollmentDto enrollmentDto);
    GenericResponse<?> getAllEnrollment(Integer id);
    GenericResponse<?> getLessonList(Integer id);
    GenericResponse<?> enrollmentApproval(Integer id, Integer academicianId);
    GenericResponse<?> enrollmentRefusal(Integer id, Integer academicianId);
    GenericResponse<?> enrollmentListApproval(List<Integer> enrollmentIds, Integer academicianId);
    GenericResponse<?> enrollmentListRefusal(List<Integer> enrollmentIds, Integer academicianId);
}
