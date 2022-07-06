package com.example.personalmanage.controllers;

import com.example.personalmanage.exception.ResourceNotFoundException;
import com.example.personalmanage.models.User;
import com.example.personalmanage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    //create user
    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    //get user by username
    @GetMapping("{username}")
    public User getUserByUsername(@PathVariable String username){
        List<User> users = userRepository.findAll();
        for(User user : users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }

        throw(new ResourceNotFoundException("User not exist"));
    }

    //update user
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User userDetail){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist"));

        user.setUsername(userDetail.getUsername());
        user.setPassword(userDetail.getPassword());
        user.setEmail(userDetail.getEmail());

        userRepository.save(user);

        return ResponseEntity.ok(user);
    }

    //delete user
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delUser(@PathVariable long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist"));

        userRepository.delete(user);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
