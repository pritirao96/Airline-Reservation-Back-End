package com.lti.airlines.dto;

import java.sql.Date;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class FlightDTO {
	
	@Id
	private int flightNumber;
	private String source;
	private String destination;
	@Temporal(TemporalType.TIME)
	private Date arrivalTime;
	@Temporal(TemporalType.TIME)
	private Date departureTime;
	@Temporal(TemporalType.TIME)
	private Date duration;

	@Temporal(TemporalType.DATE)
	private Date flightdate;
	
	private double pricePerSeat;

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

	public Date getFlightdate() {
		return flightdate;
	}

	public void setFlightdate(Date flightdate) {
		this.flightdate = flightdate;
	}

	public double getPricePerSeat() {
		return pricePerSeat;
	}

	public void setPricePerSeat(double pricePerSeat) {
		this.pricePerSeat = pricePerSeat;
	}
	
}
