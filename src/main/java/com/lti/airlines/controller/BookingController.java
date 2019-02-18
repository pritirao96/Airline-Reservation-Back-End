package com.lti.airlines.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.airlines.dao.GenericDao;
import com.lti.airlines.dto.TicketGeneration;
import com.lti.airlines.entity.BookSeats;
import com.lti.airlines.entity.Flight;
import com.lti.airlines.entity.PassengerDetails;
import com.lti.airlines.entity.UserRegistration;
import com.lti.airlines.objectEnum.BookStatus;

@RestController
@CrossOrigin
public class BookingController {
	
	@Autowired
	private GenericDao genericDao;
	
	@RequestMapping(path="/book/flight", method=RequestMethod.POST)
	public Object add(@RequestBody TicketGeneration ticket) {
		genericDao.store(ticket);
		return BookStatus.bookingSuccessful;
	}
	@RequestMapping(path="/cancel/flight", method=RequestMethod.GET)
	@CrossOrigin
	public Object delete(@RequestBody BookSeats bookSeat) {
		genericDao.delete(bookSeat);
		return BookStatus.bookingCancelled;
	}
	@RequestMapping(path="/book/flight/passenger/{id}", method=RequestMethod.POST)
	@CrossOrigin
	public Object addPassenger(@RequestBody PassengerDetails[ ] passdetails,@PathVariable("id") int id) {
		UserRegistration ur = new UserRegistration();
		ur=genericDao.fetchById(UserRegistration.class,id);
		System.out.println("in booking controller");
		for(int i=0;i<passdetails.length;i++)   {    
			passdetails[i].setUserReg(ur);
			genericDao.store(passdetails[i]);
		}
		return "passengerDetailsAdded";
	}
	
	@RequestMapping(path="/show/passengers/{id}",method=RequestMethod.GET)
	@CrossOrigin
	public List<PassengerDetails> showPassenger(@RequestBody PassengerDetails[] passdetails,@PathVariable("id") int id) {
		return genericDao.fetchAllPass(id);
	}
	
	@RequestMapping(path="/show/book/flight",method=RequestMethod.GET)
	@CrossOrigin
	public List<PassengerDetails> showBook() {
		return genericDao.fetchBook(PassengerDetails.class);
	}
	
	@RequestMapping(path="/book/flight/{id}/{flight_id}",method=RequestMethod.POST)
	@CrossOrigin
	public Object addBooking(@RequestBody BookSeats bookSeat, @PathVariable("id") int id, @PathVariable("flight_id") int flight_id) {
		UserRegistration ur= new UserRegistration();
		ur= genericDao.fetchById(UserRegistration.class,id);
		bookSeat.setUserRegistration(ur);
		Flight flight = new Flight();
		flight=genericDao.fetchById(Flight.class, flight_id);
		bookSeat.setFlight(flight);
		genericDao.store(bookSeat);
		return "booking done";
	}	
	
	@RequestMapping(path="/show/flight/{id}", method=RequestMethod.GET)
	@CrossOrigin
	public Flight showFlight(@PathVariable("id") int id) {
		return genericDao.fetchById(Flight.class, id);
	}
}
