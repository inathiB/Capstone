package com.example.demo.Collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document
public class ApplicationCreation {
    @Id
   /* @Indexed(unique = true)*/
    private String id;
    private String department;
    private String details;   
    private LocalDateTime duedate;

    public ApplicationCreation(String department, String details, LocalDateTime duedate) {
        this.department = department;
        this.details = details;
        this.duedate = duedate;
    }
}
