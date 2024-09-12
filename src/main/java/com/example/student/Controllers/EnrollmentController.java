package com.example.student.Controllers;

import com.example.student.Dto.EnrollmentDto;
import com.example.student.ResponseMessage.GenericResponse;
import com.example.student.Services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dersKayit")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;
    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }
    @PostMapping("/save")
    public GenericResponse<?> createEnrollment(@RequestBody EnrollmentDto enrollmentDto) {
        return enrollmentService.saveEnrollment(enrollmentDto);
    }


}
