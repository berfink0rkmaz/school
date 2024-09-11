package com.example.student.Controllers;

import com.example.student.Constants;
import com.example.student.Entities.Lessons;
import com.example.student.GenericResponse;
import com.example.student.Services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        System.out.println("getAllLessons called");
        List<Lessons> lessons = lessonService.getAllLessons();
        if(lessons.isEmpty()) {
            return GenericResponse.error(Constants.EMPTY_LIST);
        }else{
            return GenericResponse.success(lessons);
        }
    }
    @GetMapping("/find-By-DersKodu")
    public GenericResponse<?> getLessonsByDersKodu(@RequestParam String dersKodu) {
        System.out.println("getLessonsByDersKodu called");
            Lessons lesson = lessonService.findByDersKodu(dersKodu);
            if(lesson == null) {
                /*return ResponseEntity.ok("Bu dersKodu'na sahip Lesson sistemde yok");*/
                //return ResponseEntity.badRequest().body("hsts");
                return GenericResponse.error(Constants.EMPTY_DERSKODU);
            }else{
                return GenericResponse.success(lesson);
                /*return new ResponseEntity<>(lesson,HttpStatus.OK);*/
                //return ResponseEntity.ok(lesson);
            }
    }
    @GetMapping("/find-By-Id")
    public GenericResponse<?> getLessonById(@RequestParam Integer id) {
        System.out.println("getLessonById called");
        Optional<Lessons> lesson =lessonService.findLessonById(id);
        if (lesson.isPresent()) {
            return GenericResponse.success(lesson.get());
        }else{
            return GenericResponse.error(Constants.EMPTY_ID);
        }
    }
    @PostMapping("/save")
    public GenericResponse<?> createLesson(@RequestBody Lessons lesson) {
        System.out.println("save lesson called...");
        Lessons lessonExists= lessonService.findByDersKodu(lesson.getDersKodu());
        if(lessonExists == null){
            lessonService.saveLesson(lesson);
            return GenericResponse.success(lesson);
        }
        else {
            return GenericResponse.error(Constants.FOUND_DERSKODU);
        }
    }
    @DeleteMapping("/delete")
    public GenericResponse<?> deleteLesson(@RequestBody Lessons lesson) {
        System.out.println("delete lesson called...");
        Lessons lessonExists= lessonService.findByDersKodu(lesson.getDersKodu());
        if(lessonExists == null){
            return GenericResponse.error(Constants.EMPTY_DERSKODU);
        }else{
            lessonService.deleteLesson(lessonExists);
            return GenericResponse.success(lessonExists);
        }
    }
    @DeleteMapping("/delete/{id}")
    public GenericResponse<?> deleteLessonById(@PathVariable Integer id) {
        System.out.println("delete lesson called...");
        Optional<Lessons> lesson =lessonService.findLessonById(id);
        if (lesson.isPresent()) {
            lessonService.deleteLesson(lesson.get());
            return GenericResponse.success(lesson.get());
        }else {
            return GenericResponse.error(Constants.EMPTY_ID);
        }
    }
    @PutMapping("/update")
    public GenericResponse<?> updateLesson(@RequestBody Lessons lesson) {
        System.out.println("update lesson called...");
        Lessons lessonExists= lessonService.findByDersKodu(lesson.getDersKodu());
        if(lessonExists == null){
            return GenericResponse.error(Constants.EMPTY_DERSKODU);
        }else{
            Lessons updatedLesson= lessonService.updateLesson(lesson);
            return GenericResponse.success(updatedLesson);
        }
    }
}
