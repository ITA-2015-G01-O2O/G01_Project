package com.group.tto.admin.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseDao<T> {
  @PersistenceContext
  private EntityManager entityManager;

  private Class<T> clazz;

  public BaseDao(Class<T> clazz) {
    this.clazz = clazz;
  }

  public EntityManager getEntityManager() {
    return entityManager;
  }

  public void setEntityManager(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public void create(T obj) {
    this.entityManager.persist(obj);
  }

  public T update(T obj) {
    return this.entityManager.merge(obj);
  }

  public void delete(T obj) {
    this.entityManager.remove(obj);
  }

  public T find(Serializable id) {
    return this.entityManager.find(clazz, id);
  }

  public List<T> findAll() {
    return this.entityManager.createQuery("from " + clazz.getSimpleName()).getResultList();
  }


}
