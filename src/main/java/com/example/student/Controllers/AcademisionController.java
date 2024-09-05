package com.example.student.Controllers;

import com.example.student.Constants;
import com.example.student.Entities.Academisions;
import com.example.student.GenericResponse;
import com.example.student.Services.AcademisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Academisions")
public class AcademisionController {
    private final AcademisionService academisionService;

    @Autowired
    public AcademisionController(AcademisionService academisionService) {
        this.academisionService = academisionService;
    }
    @GetMapping("/getAll")
    public GenericResponse<?> getAllAcademisions() {
        System.out.println("getAllAcademisions called");
        List<Academisions> academisions = academisionService.getAllAcademisions();
        if(academisions.isEmpty()) {
            return GenericResponse.error(Constants.EMPTY_LIST);
        }else{
            return GenericResponse.success(academisions);
        }
    }
    @GetMapping("/find-By-TcNo")
    public GenericResponse<?> getAcademisionByTcNo(@RequestParam String tcNo) {
        System.out.println("getAcademisionByTcNo called");
        Academisions academision = academisionService.findByTcNo(tcNo);
        if(academision == null) {
            return GenericResponse.error(Constants.EMPTY_TCNO);
        }else{
            return GenericResponse.success(academision);
        }
    }
    @GetMapping("find-by-id")
    public GenericResponse<?> getAcademisionById(@RequestParam Integer id) {
        System.out.println("getAcademisionById called");
        Optional<Academisions> academision = academisionService.findById(id);
        if(academision.isPresent()) {
            return GenericResponse.success(Constants.Found_ID);
        }else{
            return GenericResponse.error(Constants.EMPTY_ID);
        }
    }
    @PostMapping("/save")
    public GenericResponse<?> createAcademision(@RequestBody Academisions academision) {
        System.out.println("save academision called...");
        Academisions academisionExists = academisionService.findByTcNo(academision.getTcNo());
        if(academisionExists == null) {
            academisionService.saveAcademision(academision);
            return GenericResponse.success(academision);
        }else{
            return GenericResponse.error(Constants.FOUND_TCNO);
        }
    }
    @DeleteMapping("/delete")
    public GenericResponse<?> deleteAcademision(@RequestBody Academisions academision) {
        System.out.println("delete academision called...");
        Academisions academisionExists = academisionService.findByTcNo(academision.getTcNo());
        if(academisionExists == null) {
            return GenericResponse.error(Constants.EMPTY_TCNO);
        }else {
            academisionService.deleteAcademision(academisionExists);
            return GenericResponse.success(academisionExists);
        }
    }
    @DeleteMapping("/delete/{id}")
    public GenericResponse<?> deleteAcademision(@PathVariable Integer id) {
        System.out.println("delete academision by id called...");
        Optional<Academisions> academision = academisionService.findById(id);
        if(academision.isPresent()) {
            academisionService.deleteAcademision(academision.get());
            return GenericResponse.success(academision.get());
        }else{
            return GenericResponse.error(Constants.EMPTY_ID);
        }
    }
    @PutMapping("/update")
    public GenericResponse<?> updateAcademision(@RequestBody Academisions academision) {
        System.out.println("update academision called...");
        Academisions academisionExists = academisionService.findByTcNo(academision.getTcNo());
        if (academisionExists == null) {
            return GenericResponse.error(Constants.EMPTY_TCNO);
        } else {
            Academisions updatedAcademision = academisionService.updateAcademision(academision);
            return GenericResponse.success(updatedAcademision);
        }
    }
}
