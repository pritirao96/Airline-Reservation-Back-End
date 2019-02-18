package com.lti.airlines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.airlines.dao.GenericDao;
import com.lti.airlines.dto.FlightDTO;
import com.lti.airlines.entity.Flight;

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
		flight.setFlightdate(flightDto.getFlightdate());
		flight.setDuration(flightDto.getDuration());
		flight.setPricePerSeat(flightDto.getPricePerSeat());
		
		genericDao.store(flight);

	}

	@Transactional
	public void deleteFlight(int flightNumber) {
		genericDao.delete(Flight.class, flightNumber);

	}

}
