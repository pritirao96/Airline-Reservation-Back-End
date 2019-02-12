package com.lti.airlines.test;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import com.lti.airlines.controller.LoginController;
import com.lti.airlines.dao.GenericDao;
import com.lti.airlines.entity.Flight;
import com.lti.airlines.entity.FlightPrice;
import com.lti.airlines.entity.Payment;
import com.lti.airlines.entity.UserRegistration;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
//@AutoConfigureTestDatabase(replace=Replace.NONE)
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
		//UserRegistration userRegistration=new UserRegistration();
		UserRegistration userRegistration= genericDao.fetchById(UserRegistration.class,101);
		System.out.println(userRegistration.getEmail());
		
	}
	
	
}

