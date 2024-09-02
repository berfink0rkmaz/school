package com.example.student.Controllers;

import com.example.student.Entities.Academisions;
import com.example.student.Services.AcademisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Academisions")
public class AcademisionController {
    private AcademisionService academisionService;
    @Autowired
    public AcademisionController(AcademisionService academisionService) {
        this.academisionService = academisionService;
    }
    @PostMapping
    public Academisions createAcademision(@RequestBody Academisions academision) {
        System.out.println("save academision called...");
        return academisionService.saveAcademision(academision);
    }
}
