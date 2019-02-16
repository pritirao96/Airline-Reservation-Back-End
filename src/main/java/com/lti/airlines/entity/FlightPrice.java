package com.lti.airlines.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class FlightPrice {

	@Id
	@GeneratedValue
	private int flightPriceId;

	@JsonIgnore
	@OneToOne()
	@JoinColumn(name="flightNumber", unique=true)
	private Flight flight;

	@Column(nullable = false, columnDefinition = "int default 50")
	private int noOfSeats;
	
	private double pricePerSeat;
	
	@OneToMany(mappedBy="flight")
	private Set<BookSeats> bookSeat;
	
	public int getFlightPriceId() {
		return flightPriceId;
	}

	public void setFlightPriceId(int flightPriceId) {
		this.flightPriceId = flightPriceId;
	}

	
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public FlightPrice(Flight flight) {
		super();
		this.flight = flight;
	}

	public FlightPrice() {
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
