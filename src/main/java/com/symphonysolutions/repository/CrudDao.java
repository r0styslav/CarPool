package com.symphonysolutions.repository;

import java.util.List;

public interface CrudDao<T> {
    T get(int id);

    void delete(int id);

    void delete(T entity);

    List<T> getAll();

    T update(T entity);

    T create(T entity);
}
