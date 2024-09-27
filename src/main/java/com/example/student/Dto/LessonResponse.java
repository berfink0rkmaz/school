package com.example.student.Dto;

import com.example.student.Entities.Academician;
import com.example.student.Entities.Student;
import lombok.Data;

import java.util.List;

@Data
public class LessonResponse {

    private Integer id;
    private String name;
    private int courseCredit;
    private String department;
    private String courseCode;
    private int quota;
    private String semester;
    private int year;
    private boolean deleted = false;
    private List<Integer> studentList;
    private Integer academistId;
}
