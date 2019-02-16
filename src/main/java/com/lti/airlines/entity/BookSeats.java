package com.lti.airlines.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Booking_Table")
public class BookSeats {

	@Id
	@GeneratedValue
	private int bookId; 
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserRegistration userRegistration;

	@ManyToOne
	@JoinColumn(name="flight_id")
    private Flight flight;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfBooking;
	
	private int NumberOfSeats;
	
	private Double TotalPrice;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public UserRegistration getUserRegistration() {
		return userRegistration;
	}

	public void setUserRegistration(UserRegistration userRegistration) {
		this.userRegistration = userRegistration;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Date getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public int getNumberOfSeats() {
		return NumberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		NumberOfSeats = numberOfSeats;
	}

	public Double getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		TotalPrice = totalPrice;
	}
	
}
