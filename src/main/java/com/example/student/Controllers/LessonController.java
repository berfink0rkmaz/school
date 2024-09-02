package com.example.student.Controllers;

import com.example.student.Entities.Lessons;
import com.example.student.Services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Lessons")
public class LessonController {
    private final LessonService lessonService;
    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }
    @PostMapping
    public Lessons createLesson(@RequestBody Lessons lesson) {
        System.out.println("save lesson called...");
        return lessonService.saveLesson(lesson);
    }
}
