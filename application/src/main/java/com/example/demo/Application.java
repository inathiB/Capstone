package com.example.demo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
@Data
@Document
public class Application {
    @Id
    private String id;
    private String name;
    private String surname;
    @Indexed(unique = true)
    private String email;
    private Transcript transcript;
    private LocalDateTime created;

    public Application(String name, String surname, String email, Transcript transcript,LocalDateTime created) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.transcript = transcript;
        this.created = created;
    }
}
