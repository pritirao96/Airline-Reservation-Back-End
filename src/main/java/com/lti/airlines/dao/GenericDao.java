package com.lti.airlines.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.airlines.entity.Flight;

@Repository
public class GenericDao {
	@PersistenceContext
	protected EntityManager entityManager;

	@Transactional
	public void store(Object obj) {
		entityManager.merge(obj);
	}

	@Transactional
	public <E> E fetchById(Class<E> classname, Object pk) {
		E e = entityManager.find(classname, pk);
		return e;
	}

	@Transactional
	public <E> void delete(Class<E> classname, Object pk) {
		Object obj = entityManager.find(classname, pk);
		entityManager.remove(obj);
	}
	
	
	@Transactional
	public <E> List<E> fetchAll(Class<E> e) {
		Query q = entityManager.createQuery("select obj from " + e.getName() + "as obj");
		return q.getResultList();
	}

}
