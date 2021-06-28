package com.company.springSecurity.repo;


import com.company.springSecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    default User findByUsername(String username){
        return null;
    }
}
