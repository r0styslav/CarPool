package com.symphonysolutions.service.impl;

import com.symphonysolutions.model.User;
import com.symphonysolutions.repository.UserRepository;
import com.symphonysolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

//    @Autowired
////    private UserRepositoryImpl userRepository;
//    private CrudDao<User> userRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public User createUser(User user) {
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


}
