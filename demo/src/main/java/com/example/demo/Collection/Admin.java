package com.example.demo.Collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Admin extends User {
@Id
    private String employeeID;
    private String name;

}
