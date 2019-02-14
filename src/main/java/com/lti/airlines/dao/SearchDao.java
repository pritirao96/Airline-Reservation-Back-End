package com.lti.airlines.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.airlines.entity.Flight;

@Repository
public class SearchDao extends GenericDao {

	@PersistenceContext
	protected EntityManager entityManager;

	@Transactional
	public List<Flight> searchFlight(String src, String dst, Date date) {
//		Query sql = entityManager
//				.createQuery("from Flight ft where ft.source= ?1 and ft.destination= ?2 and ft.flightdate=?3 ");
		Query sql = entityManager
				.createQuery("from Flight ft where ft.source=:source and ft.destination=:destination and ft.flightdate=:fdate ");
		sql.setParameter("source", src);
		sql.setParameter("destination", dst);
		sql.setParameter("fdate", date);
		return sql.getResultList();
	}

	@Transactional
	public List<Flight> listFlight() {
		Query sql = entityManager.createQuery("from Flight ft");
		return sql.getResultList();
	}
}
