package com.assessment.api.controller;

import com.assessment.api.entity.User;
import com.assessment.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping()
    public List<User> getAllUsers(){
        return service.showAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable(value = "id") int id){
        Optional<User> user = service.findUserById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public User addUser(@Validated @RequestBody User user){
        return service.saveUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") int id, @Validated @RequestBody User user){
        Optional<User> u = service.findUserById(id);
        if (u.isPresent()){
            u.get().setName(user.getName());
            u.get().setEmail(user.getEmail());
            User updatedUser = service.saveUser(u.get());
            return ResponseEntity.ok().body(updatedUser);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(value = "id") int id){
        service.deleteUserById(id);
    }


}
