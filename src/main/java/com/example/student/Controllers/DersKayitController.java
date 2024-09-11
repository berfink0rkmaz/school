package com.example.student.Controllers;

import com.example.student.Services.DersKayitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dersKayit")
public class DersKayitController {
    private final DersKayitService dersKayitService;
    @Autowired
    public DersKayitController(DersKayitService dersKayitService) {
        this.dersKayitService = dersKayitService;
    }



}
