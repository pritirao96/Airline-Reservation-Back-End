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
import com.lti.airlines.dao.PaymentDao;
import com.lti.airlines.dao.UserRegistrationDao;
import com.lti.airlines.entity.Payment;
import com.lti.airlines.entity.UserRegistration;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
//@AutoConfigureTestDatabase(replace=Replace.NONE)
public class AirlinesReservationApplicationTests {

	@Autowired
	private UserRegistrationDao userRegistrationDao;
	private PaymentDao paymentDao;
	
	@Test
	@Transactional
	public void addUser() {
		UserRegistration userRegistration =new UserRegistration();
		userRegistration.setfName("mrunal");
		userRegistration.setlName("jawanjal");
		userRegistration.setEmail("mrunal@gmail.com");
		userRegistration.setDob("15/5/14");
		userRegistration.setPassword("mrunal@123");
		userRegistration.setPhoneNo(85475);
		userRegistrationDao.add(userRegistration);
	}

	@Test
	@Transactional
	public void fetchById() {
		//UserRegistration userRegistration=new UserRegistration();
		UserRegistration userRegistration= userRegistrationDao.fetchById(101);
		System.out.println(userRegistration.getEmail());
		
	}
	
	/*public void login() {
		LoginController loginController;
	}*/
	
//	@Test
//	@Transactional
//	public void addUser1() {
//		Payment payment=new Payment();
//		payment.setfName("prachi");
//		payment.setlName("thorat");
//		payment.setBalance(50000);
//		paymentDao.add(payment);
//	}
}

