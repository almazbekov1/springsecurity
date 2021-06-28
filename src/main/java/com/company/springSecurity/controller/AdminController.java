package com.company.springSecurity.controller;

import com.company.springSecurity.model.User;
import com.company.springSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userRepo;

    @CrossOrigin
    @GetMapping
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @CrossOrigin
    @PostMapping
    public User addUser(@RequestBody User user){
        System.out.println("post mapping");
        System.out.println();
        return userRepo.save(user);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int id){
        System.out.println("get id mapping");
        System.out.println();

        return userRepo.findById((long)id);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public User putUserId(@PathVariable("id") int id,@RequestBody User user){
        user.setId((long)id);
        return userRepo.save(user);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable("id") int id){
        System.out.println("delete success user id: "+id);
        userRepo.remove((long)id);
        return userRepo.findById((long)id);
    }


}

