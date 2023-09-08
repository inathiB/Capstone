package com.example.demo.Collection;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@Getter
public class Course {

        @Id
        private String courseCode;
        private String name;
        private List <CourseConvener> courseConveners;
        private List<Tutor> tutors;


    public Course(String courseCode, String name) {
        this.courseCode = courseCode;
        this.name = name;
    }
}

