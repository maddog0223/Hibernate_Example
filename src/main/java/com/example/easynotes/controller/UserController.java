package com.example.easynotes.controller;


import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.User;
import com.example.easynotes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    //Get all hibernate method with CrudRepository
    @GetMapping("/find")
    public Iterable<User> getAllUsers(){ return userRepository.findAll(); }


    //Get by id
    @GetMapping("/find/{id}")
    public Optional<User> getByUsersId(@PathVariable (value = "id") Long userid){

        return userRepository.findById(userid);

    }

   //Post
    @PostMapping("/create")
    public User createNewUser(@Valid @RequestBody User user){return userRepository.save(user);}

    //Update
    @PutMapping("/update/{id}")
    public User updateUser( @PathVariable (value ="id") Long userid,
                            @Valid @RequestBody User userinfo) {

        User user = userRepository.findById(userid)
                .orElseThrow(() -> new ResourceNotFoundException("In User", "id", userid));

        user.setFname(userinfo.getFname());
        user.setLname(userinfo.getLname());
        user.setFavorite_drink(user.getFavorite_drink());

        User updateuser = userRepository.save(user);

        return updateuser;
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public User updateUser( @PathVariable (value ="id")Long userid) {

        User user = userRepository.findById(userid)
                .orElseThrow(() -> new ResourceNotFoundException("User","id", userid));


        userRepository.delete(user);

        return user;
    }


}
