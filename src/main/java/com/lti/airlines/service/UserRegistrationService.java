package com.lti.airlines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.airlines.dao.UserRegistrationDao;
import com.lti.airlines.entity.UserRegistration;

@Service
public class UserRegistrationService {
	
	@Autowired
	private UserRegistrationDao userRegistrationDao;
	
	public void add(UserRegistration userRegistration) {
		userRegistrationDao.add(userRegistration);
	}
	
	public UserRegistration fetchById(int id) {
		return userRegistrationDao.fetchById(id);
	}
	
	
}
