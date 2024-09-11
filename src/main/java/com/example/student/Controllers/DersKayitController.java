package com.example.student.Controllers;

import com.example.student.DersKayitDto;
import com.example.student.Entities.DersKayit;
import com.example.student.GenericResponse;
import com.example.student.Services.DersKayitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dersKayit")
public class DersKayitController {
    private final DersKayitService dersKayitService;
    @Autowired
    public DersKayitController(DersKayitService dersKayitService) {
        this.dersKayitService = dersKayitService;
    }
    @PostMapping("/save")
    public GenericResponse<?> createDersKayit(@RequestBody DersKayitDto dersKayitDto ) {
        return dersKayitService.saveDersKayit(dersKayitDto);
    }


}
