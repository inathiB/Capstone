package com.example.demo.Collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class User {
    private String userName;
    private String passWord;}
