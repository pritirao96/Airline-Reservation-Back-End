package com.lti.airlines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.airlines.dao.GenericDao;
import com.lti.airlines.entity.UserRegistration;

@Service
public class UserRegistrationService {

	@Autowired
	private GenericDao genericDao;

	public void add(UserRegistration userRegistration) {
		genericDao.store(userRegistration);
	}

	public UserRegistration fetchById(int id) {
		return genericDao.fetchById(UserRegistration.class, id);
	}

}
