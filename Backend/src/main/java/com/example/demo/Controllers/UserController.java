package com.example.demo.Controllers;
import com.example.demo.Collection.User;
import com.example.demo.Logic.UserService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*API*/
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> fetchAllUsers(){
        return userService.getAllUsers();}

    @GetMapping("/{id}")
    public User getUser(@ PathVariable String id) {
        return userService.getUser(id);}

    @PostMapping("/adduser")
    public void addUser(@RequestBody User user) throws MessagingException {
        userService.addUser(user);}

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return "success";}

    @PutMapping ("/promotetotutor")
    public void ChangerRoletoTutor(@RequestBody String username){
        userService.makeRoleTutor(username);
    }
    @PutMapping("/updateUser")
    public void updateUser(@RequestBody User username){
        userService.updateUser(username);
    }


}


