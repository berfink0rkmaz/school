package com.example.student.Controllers;

import com.example.student.Dto.EnrollmentDto;
import com.example.student.ResponseMessage.GenericResponse;
import com.example.student.Services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/getAllEnrollment")
    public GenericResponse<?> getAllEnrollment(@RequestParam Integer id) {
        return enrollmentService.getAllEnrollment(id);
    }
    @GetMapping("/getLessonList")
    public GenericResponse<?> getLessonList(@RequestParam Integer id) {
        return enrollmentService.getLessonList(id);
    }
    @PostMapping("/enrollmentApproval")
    public GenericResponse<?> enrollmentApproval(@RequestParam Integer id,@RequestParam Integer academicianId) {
        return enrollmentService.enrollmentApproval(id, academicianId);
    }
    @PostMapping("/enrollmentRefusal")
    public GenericResponse<?> enrollmentRefusal(@RequestParam Integer id,@RequestParam Integer academicianId) {
        return enrollmentService.enrollmentRefusal(id, academicianId);
    }
    @PostMapping("/enrollmentListApproval")
    public GenericResponse<?> enrollmentListApproval(@RequestBody List<Integer> enrollmentIds,@RequestParam Integer academicianId) {
        return enrollmentService.enrollmentListApproval(enrollmentIds, academicianId);
    }
    @PostMapping("/enrollmentListRefusal")
    public GenericResponse<?> enrollmentListRefusal(@RequestBody List<Integer> enrollmentIds,@RequestParam Integer academicianId) {
        return enrollmentService.enrollmentListRefusal(enrollmentIds, academicianId);
    }

}
