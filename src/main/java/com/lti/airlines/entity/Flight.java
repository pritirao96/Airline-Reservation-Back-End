package com.lti.airlines.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
	@Column(nullable = false, columnDefinition = "int default 50")
	private int noOfSeats;
	private double pricePerSeat;
	
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

	public String getFlightdate() {
		return flightdate;
	}

	public void setFlightdate(String flightdate) {
		this.flightdate = flightdate;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public double getPricePerSeat() {
		return pricePerSeat;
	}

	public void setPricePerSeat(double pricePerSeat) {
		this.pricePerSeat = pricePerSeat;
	}

	public Set<BookSeats> getBookSeat() {
		return bookSeat;
	}

	public void setBookSeat(Set<BookSeats> bookSeat) {
		this.bookSeat = bookSeat;
	}

}
