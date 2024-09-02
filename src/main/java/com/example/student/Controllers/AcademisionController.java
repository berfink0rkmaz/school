package com.example.student.Controllers;

import com.example.student.Entities.Academisions;
import com.example.student.Services.AcademisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Academisions")
public class AcademisionController {
    private AcademisionService academisionService;
    @Autowired
    public AcademisionController(AcademisionService academisionService) {
        this.academisionService = academisionService;
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllAcademisions() {
        System.out.println("getAllAcademisions called");
        List<Academisions> academisions = academisionService.getAllAcademisions();
        return new ResponseEntity<>(academisions, HttpStatus.OK);
    }
    @GetMapping("findByTcNo")
    public ResponseEntity<?> getAcademisionByTcNo(@RequestParam String tcNo) {
        System.out.println("getAcademisionByTcNo called");
        Academisions academision = academisionService.findbyTcNo(tcNo);
       return new ResponseEntity<>(academision, HttpStatus.OK);
    }
    @PostMapping("/save")
    public Academisions createAcademision(@RequestBody Academisions academision) {
        System.out.println("save academision called...");
        return academisionService.saveAcademision(academision);
    }
    @DeleteMapping("/delete")
    public void deleteAcademision(@RequestBody Academisions academision) {
        System.out.println("delete academision called...");
        academisionService.deleteAcademision(academision);
    }
    /*@PutMapping("/update")
    public Academisions updateAcademision(@PathVariable int id, @RequestBody Academisions academisionDetails) {
        return academisionService.updateAcademision(id, academisionDetails);
    }*/
}
