package com.lti.airlines.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.airlines.dao.GenericDao;
import com.lti.airlines.entity.BookSeats;
import com.lti.airlines.entity.PassengerDetails;
import com.lti.airlines.objectEnum.BookStatus;

@RestController
@CrossOrigin
public class BookingController {
	
	@Autowired
	private GenericDao genericDao;
	
	@RequestMapping(path="/book/flight", method=RequestMethod.POST)
	public Object add(@RequestBody BookSeats bookSeat) {
		genericDao.store(bookSeat);
		return BookStatus.bookingSuccessful;
	}
	@RequestMapping(path="/cancel/flight/{bookId}", method=RequestMethod.GET)
	@CrossOrigin
	public Object delete(@PathVariable("bookId") int bookId) {
		genericDao.delete(BookSeats.class,bookId);
		return BookStatus.bookingCancelled;
	}
	@RequestMapping(path="/book/flight/passenger", method=RequestMethod.POST)
	@CrossOrigin
	public Object addPassenger(@RequestBody PassengerDetails[ ] passdetails) {
		for(int i=0;i<passdetails.length;i++)   {                    //newly added
		genericDao.store(passdetails);
		}
		return BookStatus.passengerDetailsAdded;
	}
	
}
