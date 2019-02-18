package com.lti.airlines.test;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.lti.airlines.dao.GenericDao;
import com.lti.airlines.dao.SearchDao;
import com.lti.airlines.entity.Flight;
import com.lti.airlines.entity.FlightPrice;
import com.lti.airlines.entity.UserRegistration;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class AirlinesReservationApplicationTests {

	@Autowired
	private GenericDao genericDao;

	@Autowired
	private SearchDao searchDao;

	@Test
	@Transactional
	public void addUser() {
		UserRegistration userRegistration = new UserRegistration();
		userRegistration.setfName("Amar");
		userRegistration.setlName("Panchal");
		userRegistration.setEmail("amar@gmail.com");
		userRegistration.setDob("16/05/1996");
		userRegistration.setPassword("amar@123");
		userRegistration.setPhoneNo(996630213);
		genericDao.store(userRegistration);
	}

	@Test
	@Transactional
	public void fetchById() {
		UserRegistration userRegistration = genericDao.fetchById(UserRegistration.class, 101);
		System.out.println(userRegistration.getEmail());

	}

	@Test
	@Transactional
	public void add() throws ParseException {

		Flight flight = new Flight();
		flight.setFlightNumber(128);
		flight.setSource("Mumbai");
		flight.setDestination("Chennai");
		flight.setArrivalTime("5:30:00");
		flight.setDepartureTime("2:30:00");
		flight.setDuration("2:30:00");
		flight.setFlightdate("2019-02-21");
		flight.setPricePerSeat(5560);

		genericDao.store(flight);
	}

	@Test
	@Transactional
	public void deleteFlight() {
		Flight flight = new Flight();
		flight.setFlightNumber(120);
		genericDao.delete(flight.getFlightNumber());
	}

	@Test
	@Transactional
	public void searchFlight() {
		List<Flight> a = searchDao.searchFlight("Chennai", "Banglore","2019-02-19");
		assertEquals(1, a.size());
	}
}
