package com.example.demo.Collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document

public class Tutor extends User {
    private String name;
    @Id
    private String studentID;
    private  String phone;


}
