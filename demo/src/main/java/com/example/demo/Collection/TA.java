package com.example.demo.Collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class TA extends User {
        @Id
        private int employeeID;
        private String name;


}
