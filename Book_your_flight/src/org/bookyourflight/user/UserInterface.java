package org.bookyourflight.user;

import org.bookyourflight.flights.Destination;

public interface UserInterface {
//Interface	defines the behavior of the class 
	public String getFullName();
	public void setFullName(String fullName) throws UserException;
	public String getEmail();
	public void setEmail(String email) throws UserException; 
	public String getPhoneNumber();
	public void setPhoneNumber(String phoneNumber) throws UserException;
	public Destination getCountry();
	public void setCountry(Destination country);
	
}