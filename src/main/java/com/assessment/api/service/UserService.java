package com.assessment.api.service;

import com.assessment.api.entity.User;
import com.assessment.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> showAllUsers(){
        return repository.findAll();
    }

    public Optional<User> findUserById(int id){
        return repository.findById(id);
    }

    public User saveUser (User user){ return repository.save(user); }

    public void deleteUserById(int id){ repository.deleteById(id); }

}
