package com.company.springSecurity.repo;


import com.company.springSecurity.model.User;
import com.company.springSecurity.service.UserService;
import com.company.springSecurity.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Autowired
//    TestUserRepo userRepo = null;
//
//    default User findByUsername(String username){
//        List<User> users = userRepo.findAll();
//        for (User user:users) {
//            if (username == user.getFirstName()){
//                return user;
//            }
//        }
//        return null;
//    }
//    User findByUsername(String u);
}
