package com.lti.airlines.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

//import org.hibernate.query.criteria.internal.compile.CriteriaQueryTypeQueryAdapter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.airlines.entity.UserRegistration;

@Repository
public class UserRegistrationDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void  add(UserRegistration userRegistartion) {
		entityManager.persist(userRegistartion);
	}
	
	@Transactional
	public UserRegistration fetchById(int id) {
		return entityManager.find(UserRegistration.class, id);
	}
	
	@Transactional
	public List<UserRegistration> fetchAll() {
		Query q=entityManager.createQuery("select obj from UserRegistration as obj");
		return q.getResultList();
	}
	
	

}
