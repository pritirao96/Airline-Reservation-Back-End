package com.lti.airlines.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Flight {

	@Id
	private int flightNumber;
	private String source;
	private String destination;
	@Temporal(TemporalType.DATE)
	private Date arrivalTime;
	@Temporal(TemporalType.DATE)
	private Date departureTime;
	@Temporal(TemporalType.DATE)
	private Date duration;

	@Temporal(TemporalType.DATE)
	//@Column(name = "flightdate")
	private Date flightdate;
	// private Calendar date;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "flight", cascade = CascadeType.ALL)
	private FlightPrice flightPrice;

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

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getDuration() {
		return duration;
	}

	public void setDuration(Date duration) {
		this.duration = duration;
	}

	public FlightPrice getFlightPrice() {
		return flightPrice;
	}

	public void setFlightPrice(FlightPrice flightPrice) {
		this.flightPrice = flightPrice;
	}

	public Date getFlightDate() {
		return flightdate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightdate = flightDate;
	}

}
