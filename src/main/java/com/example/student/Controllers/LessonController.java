package com.example.student.Controllers;

import com.example.student.Entities.Lessons;
import com.example.student.Services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Lessons")
public class LessonController {
    private final LessonService lessonService;
    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllLessons() {
        System.out.println("getAllLessons called");
        List<Lessons> lessons = lessonService.getAllLessons();
        return new ResponseEntity<>(lessons,HttpStatus.OK);
    }
    @PostMapping("/save")
    public Lessons createLesson(@RequestBody Lessons lesson) {
        System.out.println("save lesson called...");
        return lessonService.saveLesson(lesson);
    }
}
