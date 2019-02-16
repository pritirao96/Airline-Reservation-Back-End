package com.lti.airlines.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class UserRegistration {
	
	@GeneratedValue
	@Id
	private int id;

	@NotNull
	private String fName;

	@NotNull
	private String lName;

	@Column(unique = true)
	private String email;

	private String password;
	private String dob;
	private double phoneNo;
	
	@OneToMany(mappedBy="userRegistration")
	private Set<BookSeats> bookseats;

	@OneToMany(mappedBy="userReg")
	private Set<PassengerDetails> passdetails;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public double getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(double phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Set<BookSeats> getBookseats() {
		return bookseats;
	}

	public void setBookseats(Set<BookSeats> bookseats) {
		this.bookseats = bookseats;
	}

	public Set<PassengerDetails> getPassdetails() {
		return passdetails;
	}

	public void setPassdetails(Set<PassengerDetails> passdetails) {
		this.passdetails = passdetails;
	}

}
