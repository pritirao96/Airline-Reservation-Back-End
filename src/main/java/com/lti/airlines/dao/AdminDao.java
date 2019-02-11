package com.lti.airlines.dao;
import com.lti.airlines.dao.*;
import com.lti.airlines.entity.AdminLogin;
import com.lti.airlines.entity.Flight;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AdminDao {
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void addFlight(Object obj) {
		System.out.println("In dao addflight");
		entityManager.persist(obj);
	}
	
	@Transactional
	public void deleteFlight(int flightNumber) {
			Flight flight=entityManager.find(Flight.class, flightNumber);
		    entityManager.remove(flight);
		}
	
	
	@Transactional
	public void add(AdminLogin adminLogin) {
		System.out.println("In dao adminlogin");
		entityManager.persist(adminLogin);
	}
	
	
}
