package com.example.student.Mapper;

import com.example.student.Dto.LessonResponse;
import com.example.student.Entities.Lesson;
import com.example.student.Entities.Student;

import java.util.List;
import java.util.stream.Collectors;

public class LessonMapperClaz {

    public static List<LessonResponse> toLessonResponseList(List<Lesson> lessons) {
        return lessons.stream().map(lesson -> { //
            LessonResponse response = new LessonResponse();
            response.setId(lesson.getId());
            response.setName(lesson.getName());
            response.setCourseCredit(lesson.getCourseCredit());
            response.setDepartment(lesson.getDepartment());
            response.setCourseCode(lesson.getCourseCode());
            response.setQuota(lesson.getQuota());
            response.setSemester(lesson.getSemester());
            response.setYear(lesson.getYear());
            response.setDeleted(lesson.isDeleted());

            // Akademisyen bilgilerini eklemek isterseniz:
            if (lesson.getAcademist() != null) {
                response.setAcademistId(lesson.getAcademist().getId()); // veya gerekli dönüşümü yapabilirsiniz
            }
            /*if (lesson.getStudentList() != null) {
                List<Integer> studentIds = lesson.getStudentList().stream()
                        .map(Student::getId) // Öğrenci kimliklerini alıyoruz
                        .collect(Collectors.toList());
                response.setStudentList(studentIds);
            }*/

            return response;
        }).collect(Collectors.toList());
    }
}
