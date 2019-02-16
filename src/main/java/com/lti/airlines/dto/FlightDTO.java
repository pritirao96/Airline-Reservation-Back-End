package com.lti.airlines.dto;

import java.sql.Date;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class FlightDTO {
	
	private int flightNumber;
	private String source;
	private String destination;
	private String arrivalTime;
	private String departureTime;
	private String duration;
	private String flightdate;
	
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

	public String getFlightdate() {
		return flightdate;
	}

	public void setFlightdate(String flightdate) {
		this.flightdate = flightdate;
	}

	public double getPricePerSeat() {
		return pricePerSeat;
	}

	public void setPricePerSeat(double pricePerSeat) {
		this.pricePerSeat = pricePerSeat;
	}

	@Override
	public String toString() {
		return "FlightDTO [flightNumber=" + flightNumber + ", source=" + source + ", destination=" + destination
				+ ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + ", duration=" + duration
				+ ", flightdate=" + flightdate + ", pricePerSeat=" + pricePerSeat + "]";
	}
	
	
}
