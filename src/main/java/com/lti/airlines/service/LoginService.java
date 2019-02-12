package com.lti.airlines.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.airlines.dao.GenericDao;
import com.lti.airlines.dao.SearchDao;
import com.lti.airlines.entity.AdminLogin;
import com.lti.airlines.entity.Flight;
import com.lti.airlines.entity.UserRegistration;

@Service
public class LoginService {

	@Autowired
	private GenericDao genericDao;
	
	@Autowired
	private SearchDao searchDao;

	public boolean verifyUser(UserRegistration userRegistration) {
		String email = userRegistration.getEmail();
		String password = userRegistration.getPassword();
		boolean flag = false;
		List<UserRegistration> userRegistrationList = genericDao.fetchAll(UserRegistration.class);

		for (UserRegistration userRegistration1 : userRegistrationList) {
			if (email.equals(userRegistration1.getEmail())) {
				if (password.equals(userRegistration1.getPassword())) {
					flag = true;
					return flag;
				}
			}
			// return flag;
		}
		return flag;
	}
	
	public boolean verifyAdmin(AdminLogin adminLogin) {
		String email = adminLogin.getEmailId();
		String password = adminLogin.getPassword();
		boolean flag = false;
		List<AdminLogin> adminLoginList = genericDao.fetchAll(AdminLogin.class);

		for (AdminLogin adminLogin1 : adminLoginList) {
			if (email.equals(adminLogin1.getEmailId())) {
				if (password.equals(adminLogin1.getPassword())) {
					flag = true;
					return flag;
				}
			}
			// return flag;
		}
		return flag;
	}
	
	@Transactional
	public List<Flight> searchFlight(String src,String dst){
		System.out.println("In dao searchFlight");
		return searchDao.searchFlight(src,dst);
	}
}
