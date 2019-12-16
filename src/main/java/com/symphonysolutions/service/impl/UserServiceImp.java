package com.symphonysolutions.service.impl;

import com.symphonysolutions.model.Role;
import com.symphonysolutions.model.User;
import com.symphonysolutions.repository.RolerRepository;
import com.symphonysolutions.repository.UserRepository;
import com.symphonysolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

//    @Autowired
////    private UserRepositoryImpl userRepository;
//    private CrudDao<User> userRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolerRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

    @Override
    public User getCurrentUser(Long id) {
        return userRepository.findById(id)
                .orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
//        return userRepository.getAll();
        return userRepository.findAll();
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


}
