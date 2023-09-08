package com.example.demo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Application {
    @Id
    private String id;
    private String studentNo;
    private String name;
    private String surname;
    @Indexed(unique = true)
    private String email;
    private String yearofStudy;
    private Transcript transcript;
    private LocalDateTime created;

    public Application(String studentNo, String name, String surname, String email, String yearofStudy, Transcript transcript,LocalDateTime created) {
        this.studentNo= studentNo;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.yearofStudy = yearofStudy;
        this.transcript = transcript;
        this.created = created;
    }
}
