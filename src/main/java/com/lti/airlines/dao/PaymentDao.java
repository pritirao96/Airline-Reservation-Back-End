package com.lti.airlines.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.airlines.entity.Payment;
import com.lti.airlines.entity.UserRegistration;

@Repository
public class PaymentDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void  add(Payment payment) {
		entityManager.persist(payment);
	}
	
	@Transactional
	public List<Payment> fetchAll() {
		Query q=entityManager.createQuery("select obj from Payment as obj");
		return q.getResultList();
	}
	
}
