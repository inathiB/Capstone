package com.example.demo.Collection;

//import com.example.demo.Transcript;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@Document
public class ApplicationSubmission {
    @Id
    private String id;
    @Field("studentNumber")
    private String studentNumber;
    private String name;
    private String surname;
    private String email;
    private String yearOfStudy;
    private String transcript;
    private LocalDateTime created;
    private String studentNo;
    private String yearofStudy;

    public ApplicationSubmission(String studentNo, String name, String surname, String email, String yearofStudy, String transcript,LocalDateTime created) {
        this.studentNumber= studentNo;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.yearOfStudy = yearofStudy;
        this.transcript = transcript;
        this.created = created;
    }
}
