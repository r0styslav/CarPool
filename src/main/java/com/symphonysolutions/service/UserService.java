package com.symphonysolutions.service;

import com.symphonysolutions.exception.DuplicateUserException;
import com.symphonysolutions.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user) throws DuplicateUserException;

    User getCurrentUser(Long id);

    List<User> getAllUsers();
}
