package com.example.demo.Controllers;

import com.example.demo.Collection.User;
import com.example.demo.Logic.UserService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*API*/
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/registration")
@AllArgsConstructor
public class RegistrationController {


        private final UserService userService;


        @PostMapping
        public ResponseEntity<String> addUser(@RequestBody User user) throws MessagingException {

            return userService.addUser(user);}



}
