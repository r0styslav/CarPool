package com.symphonysolutions.repository.impl;

import com.symphonysolutions.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepositoryImpl extends DefaultCrudRepository<User> {

    @PersistenceContext
    private EntityManager entityManager;

    public UserRepositoryImpl() {
        super(User.class);
    }

    public User getUserByCredentials(String username, String password) {
        return new User();
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
