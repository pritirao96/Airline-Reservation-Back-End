package com.lti.airlines.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.airlines.entity.AdminLogin;
import com.lti.airlines.entity.PassengerDetails;
import com.lti.airlines.entity.UserRegistration;

@Repository
public class GenericDao {
	
	@PersistenceContext
	protected EntityManager entityManager;

	@Transactional
	public void store(Object obj) {
		entityManager.persist(obj);
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
	public <E> void delete(Object pk) {
		entityManager.remove(pk);
	}
	
	@Transactional
	public <E> List<E> fetchAll(Class<E> e) {
		Query q = entityManager.createQuery("from " + e.getName() + " as obj");
		return q.getResultList();
	}

	@Transactional
	public  UserRegistration fetchUser(String email,String password){
		Query sql= entityManager.createQuery("from UserRegistration ur where ur.email= ?1 and ur.password= ?2");
		sql.setParameter(1, email);
		sql.setParameter(2, password);
		return (UserRegistration) sql.getSingleResult();
	}
	
	@Transactional
	public  AdminLogin fetchAdmin(String email,String password){
		Query q = entityManager.createQuery("from AdminLogin as al where al.emailId= ?1 and al.password= ?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		return (AdminLogin) q.getSingleResult();
	}
	
	@Transactional
	public  List<UserRegistration> fetchBookSeats(){
		Query sql= entityManager.createQuery("from UserRegistration ur");
		return sql.getResultList();
	}

	public List<PassengerDetails> fetchBook(Class<PassengerDetails> class1) {
		Query q = entityManager.createQuery("from PassengerDetails al where al");
		return q.getResultList();
	}
	
	@Transactional
	public  List<PassengerDetails> fetchAllPass(int id){
		Query sql= entityManager.createQuery("from PassengerDetails ur where ur.id=?1");
		sql.setParameter(1, id);
		return sql.getResultList();
	}
}
