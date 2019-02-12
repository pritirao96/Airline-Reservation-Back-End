package com.lti.airlines.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.airlines.entity.Flight;

@Repository
public class SearchDao extends GenericDao{

	@PersistenceContext
	protected EntityManager entityManager;
	
	@Transactional
	public List<Flight> searchFlight(String src, String dst){
		System.out.println("In admin doa search");
		Query sql= entityManager.createQuery("select ft from Flight as ft where ft.source=?1 and ft.destination=?2");
		sql.setParameter(1, src);
		sql.setParameter(2, dst);
		
		return sql.getResultList();
	}
}
