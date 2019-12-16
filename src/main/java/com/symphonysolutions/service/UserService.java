package com.symphonysolutions.service;

import com.symphonysolutions.exception.DuplicateUserException;
import com.symphonysolutions.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user) throws DuplicateUserException;

    User getCurrentUser(Long id);

    List<User> getAllUsers();

    User findUserByEmail(String email);
}
