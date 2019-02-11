package com.lti.airlines.test;
import com.lti.airlines.*;

import static org.junit.Assert.assertEquals;

import java.sql.Time;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.lti.airlines.AdminLogin;
import com.lti.airlines.Flight;
import com.lti.airlines.dao.AdminDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class AirlinesApplicationTests {

	@Autowired
	private AdminDao adminDao;

	@Test
	@Transactional
	public void addAdmin() {
		AdminLogin adminLogin = new AdminLogin();
		adminLogin.setEmailId("prachi@lti.com");
		adminLogin.setPassword("lti");
		adminDao.add(adminLogin);

	}

	@Test
	@Transactional
	public void addFlight() {
		Flight flight = new Flight();
	flight.setFlightNumber(101);
		flight.setSource("Pune");
		flight.setDestination("Banglore");
	flight.setArrivalTime("8:35:90" );
	flight.setDuration("12:30:00");
		adminDao.addFlight(flight);
	}

	@Test
@Transactional
	public void deleteFlight() {
		Flight flight = new Flight();
		flight.setFlightNumber(101);
		
		adminDao.deleteFlight(flight.getFlightNumber());
		

	}

}
