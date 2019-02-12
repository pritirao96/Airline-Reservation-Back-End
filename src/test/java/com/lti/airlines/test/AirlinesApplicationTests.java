package com.lti.airlines.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.lti.airlines.dao.GenericDao;
import com.lti.airlines.entity.AdminLogin;
import com.lti.airlines.entity.Flight;
import com.lti.airlines.entity.FlightPrice;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class AirlinesApplicationTests {

	@Autowired
	private GenericDao genericDao;

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

		//flight.deleteFlight(flight.getFlightNumber());

	}

}
