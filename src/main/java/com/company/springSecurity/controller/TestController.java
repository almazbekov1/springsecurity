package com.company.springSecurity.controller;


import com.company.springSecurity.model.GetId;
import com.company.springSecurity.model.User;
import com.company.springSecurity.repo.GetIdRepository;
import com.company.springSecurity.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.security.Principal;

@Controller
@RequestMapping("/api")
public class TestController {


    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private GetIdRepository getIdRepository;

    @GetMapping("/admin")
    public String get(Principal principal){
        return "admin";
    }

    @GetMapping("/user")
    public String get2(Principal principal){
        User user = userService.loadUserByFirstName(principal.getName());
        getIdRepository.save(new GetId(user.getId()));
        return "user";
    }
}
