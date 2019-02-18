package com.lti.airlines.dto;

public class TicketGeneration {
	private int flightId;
	private int userId;
	private int noOfSeats;
	private double totalPrice;
	
	
	
	public TicketGeneration(int flightId, int userId, int noOfSeats, double totalPrice) {
		super();
		this.flightId = flightId;
		this.userId = userId;
		this.noOfSeats = noOfSeats;
		this.totalPrice = totalPrice;
	}
	
	
	public TicketGeneration() {
		super();
	}


	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	

}
