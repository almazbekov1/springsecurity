package com.company.springSecurity.service;

import com.company.springSecurity.model.User;
import com.company.springSecurity.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
//        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();

    }

    @Override
    public User save(User user) {
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }

    @Override
    public void remove(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User loadUserByUsername(String s) throws UsernameNotFoundException {
        List<User> users = findAll();
        return users.stream().filter(x -> x.getEmail().equals(s)).findAny().orElse(null);

    }
    @Override
    public User loadUserByFirstName(String s) throws UsernameNotFoundException {
        List<User> users = findAll();
        return users.stream().filter(x -> x.getFirstName().equals(s)).findAny().orElse(null);

    }
}
