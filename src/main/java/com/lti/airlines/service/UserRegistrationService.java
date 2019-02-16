package com.lti.airlines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.airlines.dao.GenericDao;
import com.lti.airlines.entity.UserRegistration;
import com.lti.airlines.objectEnum.Status;

@Service
public class UserRegistrationService {

	@Autowired
	private GenericDao genericDao;

	public Object add(UserRegistration userRegistration) {
		genericDao.store(userRegistration);
		return Status.TRUE;
	}

	public UserRegistration fetchById(int id) {
		return genericDao.fetchById(UserRegistration.class, id);
	}

}
