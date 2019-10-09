package com.symphonysolutions.repository.impl;


import com.symphonysolutions.repository.CrudDao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


public abstract class DefaultCrudRepository<T> implements CrudDao<T> {

//    @PersistenceContext
//    private EntityManager entityManager;

    private Class<T> clazz;

    public DefaultCrudRepository(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T get(int id) {
        return getEntityManager().find(clazz, id);
    }

    @Override
    public void delete(int id) {
        T entity = get(id);
        delete(entity);
    }

    @Override
    public void delete(T entity) {
        if (!getEntityManager().contains(entity)) {
            getEntityManager().merge(entity);
        }
        getEntityManager().remove(entity);
    }

    @Override
    public List<T> getAll() {
        CriteriaQuery<T> query = getEntityManager().getCriteriaBuilder().createQuery(clazz);
        CriteriaQuery<T> selectAll = query.select(query.from(clazz));
        return getEntityManager().createQuery(selectAll).getResultList();
    }

    @Override
    public T update(T entity) {
        getEntityManager().merge(entity);
        return entity;
    }

    @Override
    public T create(final T entity) {
        getEntityManager().persist(entity);
        getEntityManager().flush();
        return entity;
    }

//    protected EntityManager getEntityManager() {
//        return entityManager;
//    }


    protected abstract EntityManager getEntityManager();
}

