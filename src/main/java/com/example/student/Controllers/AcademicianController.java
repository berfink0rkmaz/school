package com.example.student.Controllers;

import com.example.student.Entities.Academician;
import com.example.student.ResponseMessage.GenericResponse;
import com.example.student.Services.AcademicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Academician")
public class AcademicianController {
    private final AcademicianService academicianService;

    @Autowired
    public AcademicianController(AcademicianService academicianService) {
        this.academicianService = academicianService;
    }
    @GetMapping("/getAll")
    public GenericResponse<?> getAllAcademicians() {

        return academicianService.getAllAcademicians();
    }

    @PostMapping("/save")
    public GenericResponse<?> createAcademician(@RequestBody Academician academician) {
        return academicianService.saveAcademician(academician);
    }

    @GetMapping("find-By-Id")
    public GenericResponse<?> getAcademicianById(@RequestParam Integer id) {
        return academicianService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public GenericResponse<?> deleteAcademician(@PathVariable Integer id) {
        return academicianService.deleteAcademician(id);
    }

    @PutMapping("/update")
    public GenericResponse<?> updateAcademician(@RequestBody Academician academician) {
        return academicianService.updateAcademician(academician);
    }
}
