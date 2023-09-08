package com.example.demo.Collection;
import com.example.demo.SessionType;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.*;
import java.util.List;

@Data
@Document
@Getter

public class Tutorial {
    @Id
    private String tutorialID;
    private String courseCode;
    private DayOfWeek dayOfWeek;
    private LocalTime time;
    private List<Tutor> tutTutors;
    private SessionType sessionType;
    private int numberOfTutors;
    private String venue;

    public Tutorial(String tutorialID,String courseCode, DayOfWeek dayOfWeek, LocalTime time, int numberOfTutors) {
        this.tutorialID = tutorialID;
        this.courseCode = courseCode;
        this.dayOfWeek = dayOfWeek;
        this.time = time;
        this.numberOfTutors = numberOfTutors;
    }
}
