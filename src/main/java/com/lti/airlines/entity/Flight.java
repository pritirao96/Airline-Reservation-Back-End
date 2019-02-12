package com.lti.airlines.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Flight {
	
	@Id
	private int flightNumber;
	private String source;
	private String destination;
	private String arrivalTime;
	private String duration;
	
	@OneToOne(fetch = FetchType.LAZY, 
							mappedBy = "flight", 
							cascade = CascadeType.ALL)
	private FlightPrice flightPrice;
	
	public Flight() {

	}
	
	
	public FlightPrice getFlightPrice() {
		return flightPrice;
	}
	
	public void setFlightPrice(FlightPrice flightPrice) {
		this.flightPrice = flightPrice;
	}
	public Flight(int flightNumber, String source, String destination,String arrivalTime, String duration) {

		this.flightNumber = flightNumber;
		this.source = source;
		this.destination = destination;
		this.arrivalTime = arrivalTime;
		this.duration=duration;
	}
	
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	

	



}
