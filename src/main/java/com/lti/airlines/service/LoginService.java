package com.lti.airlines.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.airlines.dao.UserRegistrationDao;

import com.lti.airlines.entity.UserRegistration;

@Service
public class LoginService {

	@Autowired
	private UserRegistrationDao userRegistrationDao;
	private UserRegistration userRegistration;
	
	public boolean verify(UserRegistration userRegistration) {
	String email=userRegistration.getEmail();
	String password=userRegistration.getPassword();
	boolean flag=false;
	List<UserRegistration> userRegistrationList=userRegistrationDao.fetchAll();
	
	for(UserRegistration userRegistration1:userRegistrationList) {
		if(email.equals(userRegistration1.getEmail())) {
			if(password.equals(userRegistration1.getPassword())) {
				 flag=true;
				 return flag;
			}
		}
		//return flag;
	}
	return flag;
	}
}
