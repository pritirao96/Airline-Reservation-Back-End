package com.lti.airlines.test;

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
import com.lti.airlines.entity.Flight;
import com.lti.airlines.entity.FlightPrice;
import com.lti.airlines.entity.UserRegistration;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class AirlinesReservationApplicationTests {

	@Autowired
	private GenericDao genericDao;
	
	private Flight flight;
	
	@Test
	@Transactional
	public void addUser() {
		UserRegistration userRegistration =new UserRegistration();
		userRegistration.setfName("shreya");
		userRegistration.setlName("A");
		userRegistration.setEmail("shreya@gmail.com");
		userRegistration.setDob("15/5/14");
		userRegistration.setPassword("shreya@123");
		userRegistration.setPhoneNo(85475);
		genericDao.store(userRegistration);
	}

	@Test
	@Transactional
	public void fetchById() {
		UserRegistration userRegistration= genericDao.fetchById(UserRegistration.class,101);
		System.out.println(userRegistration.getEmail());
		
	}
	
	@Test
	@Transactional
	public void add() {
		
		Flight flight = new Flight();
		flight.setFlightNumber(102);
		flight.setSource("Chennai");
		flight.setDestination("Banaglore");
		flight.setArrivalTime("13:35:90");
		flight.setDuration("10:30:00");
		
		FlightPrice flightPrice = new FlightPrice();
		flightPrice.setNoOfSeats(50);
		flightPrice.setPricePerSeat(4000);
		
		flightPrice.setFlight(flight);
		flight.setFlightPrice(flightPrice);

		genericDao.store(flight);
	}

	@Test
	@Transactional
	public void deleteFlight() {
		Flight flight = new Flight();
		flight.setFlightNumber(101);
	}
	
	
}

