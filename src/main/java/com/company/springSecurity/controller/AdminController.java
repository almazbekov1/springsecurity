package com.company.springSecurity.controller;

import com.company.springSecurity.model.GetId;
import com.company.springSecurity.model.Role;
import com.company.springSecurity.model.User;
import com.company.springSecurity.repo.GetIdRepository;
import com.company.springSecurity.service.RoleService;
import com.company.springSecurity.service.RoleServiceImpl;
import com.company.springSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userRepo;

    @Autowired
    private GetIdRepository getIdRepository;

    @CrossOrigin
    @GetMapping
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @CrossOrigin
    @PostMapping
    public User addUser(@RequestBody User user){
        Set<Role> roles = new HashSet<>();
        Role role = roleService.getRoleByID(2);
        roles.add(role);
        user.setRoles(roles);
        return userRepo.save(user);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int id){
        return userRepo.findById((long)id);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public User putUserId(@PathVariable("id") int id,@RequestBody User user){
        user.setId((long)id);
        Set<Role> roles = new HashSet<>();
        Role role = roleService.getRoleByID(2);
        roles.add(role);
        user.setRoles(roles);
        return userRepo.save(user);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable("id") int id){
        userRepo.remove((long)id);
        return userRepo.findById((long)id);
    }

    @CrossOrigin
    @GetMapping("/get_user")
    public User getUser(){
        List<GetId> ids = getIdRepository.findAll();
        GetId getId = ids.get(ids.size()-1);
        User user =  userRepo.findById(getId.getId());
        return user;
    }
    @CrossOrigin
    @GetMapping("/get_id")
    public User getUserId(){
        List<GetId> ids = getIdRepository.findAll();
        GetId getId = ids.get(ids.size()-1);
        User user =  userRepo.findById(getId.getGet_id());
        return user;
    }

//    @CrossOrigin
//    @GetMapping("/test")
//    public User test(){
//        return null;
//    }


}

