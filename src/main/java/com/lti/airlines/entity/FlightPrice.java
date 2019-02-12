package com.lti.airlines.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
public class FlightPrice {

	@Id
	@GeneratedValue
	private int flightPriceId;

	@OneToOne()
	@JoinColumn(name="flightNumber")
	private Flight flight;

	private int noOfSeats;
	private double pricePerSeat;
	
	public FlightPrice() {
		
	}

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

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public double getPricePerSeat() {
		return pricePerSeat;
	}

	public void setPricePerSeat(double pricePerSeat) {
		this.pricePerSeat = pricePerSeat;
	}

	
}
