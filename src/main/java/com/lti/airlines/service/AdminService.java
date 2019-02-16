package com.lti.airlines.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.airlines.dao.GenericDao;
import com.lti.airlines.dto.FlightDTO;
import com.lti.airlines.entity.Flight;
import com.lti.airlines.entity.FlightPrice;

@Service
public class AdminService {

	@Autowired
	private GenericDao genericDao;

	@Transactional
	public void addFlight(FlightDTO flightDto) {
		Flight flight=new Flight();
		flight.setFlightNumber(flightDto.getFlightNumber());
		flight.setSource(flightDto.getSource());
		flight.setDestination(flightDto.getDestination());
		flight.setArrivalTime(flightDto.getArrivalTime());
		flight.setDepartureTime(flightDto.getDepartureTime());
		flight.setFlightDate(flightDto.getFlightdate());
		flight.setDuration(flightDto.getDuration());
		
		FlightPrice flightPrice= new FlightPrice();
		flightPrice.setPricePerSeat(flightDto.getPricePerSeat());
		
		flight.setFlightPrice(flightPrice);
		flightPrice.setFlight(flight);
		
		genericDao.store(flight);

	}

	@Transactional
	public void deleteFlight(int flightNumber) {
		genericDao.delete(Flight.class, flightNumber);

	}

}
