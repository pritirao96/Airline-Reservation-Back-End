package com.lti.airlines.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.airlines.dao.GenericDao;
import com.lti.airlines.dao.SearchDao;
import com.lti.airlines.dto.LoginDTO;
import com.lti.airlines.dto.LoginStatusDTO;
import com.lti.airlines.entity.AdminLogin;
import com.lti.airlines.entity.Flight;
import com.lti.airlines.entity.UserRegistration;

@Service
public class LoginService {

	@Autowired
	private GenericDao genericDao;
	
	@Autowired
	private SearchDao searchDao;

	public LoginStatusDTO verifyUser(LoginDTO loginDto) {
		LoginStatusDTO loginStatus= new LoginStatusDTO();
		String email = loginDto.getEmail();
		String password = loginDto.getPassword();
		
		try {
		UserRegistration log=genericDao.fetchUser(email, password);
		loginStatus.setStatus("Verified");
		loginStatus.setUserId(log.getId());
		loginStatus.setName(log.getfName());
		}
		catch(Exception e) {
			loginStatus.setStatus("Not Verified");
			e.printStackTrace();
		}
		return loginStatus;
		
	}
	
	public LoginStatusDTO verifyAdmin( LoginDTO loginDto) {
		LoginStatusDTO loginStatus= new LoginStatusDTO();
		String email = loginDto.getEmail();
		String password = loginDto.getPassword();
		
		try {
		AdminLogin log=genericDao.fetchAdmin(email, password);
		loginStatus.setStatus("Verified");
		loginStatus.setUserId(log.getId());
		loginStatus.setName(log.getEmailId());
		}
		catch(Exception e) {
			loginStatus.setStatus("NotVerified");
			e.printStackTrace();
		}
		return loginStatus;
		
	}
	
	@Transactional
	public List<Flight> searchFlight(String src,String dst,String date) throws ParseException{
		return searchDao.searchFlight(src,dst,date);
	}
	
	@Transactional
	public List<Flight> listFlight(){
		System.out.println("In dao searchFlight");
		return searchDao.listFlight();
	}
}
