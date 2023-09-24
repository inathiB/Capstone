package com.example.demo.Logic;

import com.example.demo.Collection.User;
import com.example.demo.Email.EmailService;
import com.example.demo.Repository.EmailValidator;
import com.example.demo.Repository.UserRepository;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final EmailValidator emailValidator;
    private final EmailService emailService;
    public User getUser(String email){
        Optional<User> optionalUser = userRepository.findUserByEmail(email);
        return optionalUser.orElse(null);
    }
    public List<User>getAllUsers()
    {
        return userRepository.findAll();

    }
    public ResponseEntity<String> addUser (User user) throws MessagingException {
        boolean isValidEmail = emailValidator.test(user.getEmail());

        if ((userRepository.findUserByEmail(user.getEmail()).isPresent()))
        {
            System.out.println("Duplicate");
            return new ResponseEntity<>("Email already Registered", HttpStatus.BAD_REQUEST);
            }

        if(!isValidEmail ) {return new ResponseEntity<>("Please enter a UCT email", HttpStatus.BAD_REQUEST);}

        else {
            userRepository.insert(user);
            emailService.sendRegisterationConfirmation(user.getEmail(), user);
            return  new ResponseEntity<>("User added", HttpStatus.OK);
        }}




    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public boolean login(String email , String password) {

        Optional<User> user1 = userRepository.findUserByEmail(email);

        return (user1.isPresent()) && password.equals(user1.get().getPassword());

    }

    public void makeRoleTutor(String username) {
        System.out.println("Got here");
        Optional<User> usertobePromoted = userRepository.findUserByEmail(username);
        if (usertobePromoted.isPresent()){
           User  user= usertobePromoted.get();
           user.setRole("tutor");
            userRepository.save(user);
            System.out.println("Done");
        }
    }
@Transactional
    public void updateUser(User user) {
      /*  Optional<User> users = userRepository.findUserByEmail(user.getEmail());
        if(users.isPresent()){
            User user1 = users.get();
            user1.setPassword(user.getPassword());
            user1.setRole(user.getRole());
            userRepository.save(user1);
            userRepository.delete(users.get());*/
    Optional<User> users = userRepository.findUserByEmail(user.getEmail());
    if (users.isPresent()) {
        User user1 = users.get();
        user1.setPassword(user.getPassword());
        user1.setRole(user.getRole());
        userRepository.save(user1);

        }

    }
}



