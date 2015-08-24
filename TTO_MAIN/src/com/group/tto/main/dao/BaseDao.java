package com.group.tto.main.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseDao<T> {
	@PersistenceContext
	private EntityManager entityManager;

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
}
