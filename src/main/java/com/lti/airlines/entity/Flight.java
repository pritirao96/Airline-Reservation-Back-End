package com.lti.airlines.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Flight {

	@Id
	private int flightNumber;
	private String source;
	private String destination;
	private String arrivalTime;
	private String departureTime;
	private String duration;
	private String flightdate;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "flight", cascade = CascadeType.ALL)
	private FlightPrice flightPrice;
	
	@OneToMany(mappedBy="flight", cascade = CascadeType.ALL)
	private Set<BookSeats> bookSeat;

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public FlightPrice getFlightPrice() {
		return flightPrice;
	}

	public void setFlightPrice(FlightPrice flightPrice) {
		this.flightPrice = flightPrice;
	}

	public String getFlightDate() {
		return flightdate;
	}

	public void setFlightDate(String flightDate) {
		this.flightdate = flightDate;
	}

}
