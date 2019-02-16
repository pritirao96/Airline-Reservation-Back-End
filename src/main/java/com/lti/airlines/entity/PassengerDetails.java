package com.lti.airlines.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class PassengerDetails {
	@Id
	@GeneratedValue
	private int passengerid;
	
	private String name;
	
	private String gender;
	
	private int age;
	
	@ManyToOne
	@JoinColumn(name="id")
	private UserRegistration userReg;

	private int seatno;

	public int getPassengerid() {
		return passengerid;
	}

	public void setPassengerid(int passengerid) {
		this.passengerid = passengerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public UserRegistration getUserReg() {
		return userReg;
	}

	public void setUserReg(UserRegistration userReg) {
		this.userReg = userReg;
	}

	public int getSeatno() {
		return seatno;
	}

	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}
	
}
