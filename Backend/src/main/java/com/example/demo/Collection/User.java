package com.example.demo.Collection;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data

public class User {


    private String email;
    private  String role;
    private String password;

}
