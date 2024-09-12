package com.example.student.Services;

import com.example.student.Dto.EnrollmentDto;
//import com.example.student.Entities.Enrollment;
import com.example.student.ResponseMessage.GenericResponse;
import org.springframework.stereotype.Service;

@Service
public interface EnrollmentService {
    //GenericResponse<?> getLessonsByDepartment(Integer studentId);
    GenericResponse<?> saveEnrollment(EnrollmentDto enrollmentDto);


}
