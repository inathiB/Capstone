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
        private String courseName;
        private String courseConvener;
        private List<Tutor> tutors;
        private String TA;
        private String duration;
        private String year;
        private String creator;


    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }
}

