package com.example.student.Controllers;

import com.example.student.Entities.Lesson;
import com.example.student.ResponseMessage.Constants;
import com.example.student.ResponseMessage.GenericResponse;
import com.example.student.Services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Lessons")
public class LessonController {
    private final LessonService lessonService;
    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/getAll")
    public GenericResponse<?> getAllLessons() {
        return lessonService.getAllLessons();
    }

    @PostMapping("/save")
    public GenericResponse<?> createLesson(@RequestBody Lesson lesson) {
        return lessonService.saveLesson(lesson);
    }

    @GetMapping("/find-By-Id")
    public GenericResponse<?> getLessonById(@RequestParam Integer id) {
        return lessonService.findById(id);

    }

    @DeleteMapping("/delete/{id}")
    public GenericResponse<?> deleteLesson(@PathVariable Integer id) {
        return lessonService.deleteLesson(id);
    }

    @PutMapping("/update")
    public GenericResponse<?> updateLesson(@RequestBody Lesson lesson) {
        return lessonService.updateLesson(lesson);
    }
}
