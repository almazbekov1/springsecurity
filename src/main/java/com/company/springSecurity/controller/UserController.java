package com.company.springSecurity.controller;


import com.company.springSecurity.model.GetId;
import com.company.springSecurity.model.User;
import com.company.springSecurity.repo.GetIdRepository;
import com.company.springSecurity.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private GetIdRepository getIdRepository;

//    @CrossOrigin
//    @GetMapping("/test/{id}")
//    public String test(@PathVariable Long id){
//        return "loading";
//    }
    @CrossOrigin
    @GetMapping
    public User getUser(){
        List<GetId> ids = getIdRepository.findAll();
        GetId getId = ids.get(ids.size()-1);
        User user =  userService.findById(getId.getId());
        return user;
    }
    @CrossOrigin
    @GetMapping("/get_id")
    public User getUserId(){
        List<GetId> ids = getIdRepository.findAll();
        GetId getId = ids.get(ids.size()-1);
        User user =  userService.findById(getId.getGet_id());
        return user;
    }
}

