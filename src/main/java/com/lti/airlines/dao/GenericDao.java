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
	public <E> E fetchById(Class<E> classname, int pk) {
		E e=entityManager.find(classname, pk);
		return e;
	}
	
	@Transactional
	public <E> List<E> fetchAll(Class<E> e){
		Query q= entityManager.createQuery("select obj from "+e.getName()+"as obj");
		return q.getResultList();
	}
	
	@Transactional
	public List<Flight> fetchAll(){
		Query q= entityManager.createQuery("select obj from Flight as obj");
		return q.getResultList();
	}
	
	
	
	
}
