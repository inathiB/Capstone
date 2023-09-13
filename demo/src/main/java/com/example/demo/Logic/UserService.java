package com.example.demo.Logic;

import com.example.demo.Collection.User;
import com.example.demo.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    public User getUser(String email){
        Optional<User> optionalUser = userRepository.findUserByEmail(email);
        return optionalUser.orElse(null);
    }
    public List<User>getAllUsers()
    {
        return userRepository.findAll();

    }
    public void addUser (User user){

        userRepository.insert(user);
    }
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}



