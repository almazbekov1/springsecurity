package com.company.springSecurity.controller;


import com.company.springSecurity.model.GetId;
import com.company.springSecurity.model.User;
import com.company.springSecurity.repo.GetIdRepository;
import com.company.springSecurity.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(principal.getName());
        return "admin";
    }

    @GetMapping("/user")
    public String get2(Principal principal){
        System.out.println(principal.getName());
        User user = userService.loadUserByFirstName(principal.getName());

        System.out.println(user.getId());
        System.out.println(user.getEmail());
////        return "redirect:/user/test/"+user.getId();
//        HttpSession session = req.getSession();
//
//        session.setAttribute("total","dsf");
        getIdRepository.save(new GetId(user.getId()));

        return "user";
    }
    @GetMapping("/mainTable")
    public String js(){
        return "";
    }
    @GetMapping("/mainTables")
    public String jss(HttpServletRequest req){
        HttpSession session = req.getSession();
        session.setAttribute("total","dsf");
        return "mainTable.js";
    }
}
