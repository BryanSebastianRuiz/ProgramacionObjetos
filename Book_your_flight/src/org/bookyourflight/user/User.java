package org.bookyourflight.user;

import org.bookyourflight.flights.Destination;
import org.bookyourflight.util.Utilities;

public class User implements UserInterface{
	private String FullName;
	private String Email;
	private String PhoneNumber;
	private Destination Country;
	
	
	/**
	 * Sets the initial state of the class :)
	 * @param fullName is the user fullname
	 * @param email is the user email
	 * @param phoneNumber is the user phonenumber
	 * @param country is the user nationality
	 */
	public User(String fullName,String email,String phoneNumber,Destination country) throws UserException {
		this.setFullName(fullName);
		this.setEmail(email);
		this.setPhoneNumber(phoneNumber);
		this.setCountry(country);	
	}
	
	@Override
	public String getFullName() {
		return this.FullName;
	}

	@Override
	public void setFullName(String fullName) throws UserException{
		String regex = "[^ a-zA-Z]+";
		if (Utilities.matchRegex(regex, fullName)) {
			throw new UserException("Invalid user name, characters and numbers unavalible");
		}
		this.FullName = fullName;
	}
	/*
	 * Debe de traer los datos de email
	 */
	@Override
	public String getEmail() {
		return this.Email;
	}
	/*
	 * Debe de colocar los datos de email
	 */
	@Override
	public void setEmail(String email) throws UserException{
		//holamundo37@gmail.com
		//TODO Agregar que no identifique caracteres
		String regex = "\\w+@\\w+\\.com";
		if (Utilities.matchRegex(regex, email)) {
			throw new UserException("Invalid user email, characters and numbers unavalible");
		}
		this.Email = email;
	}

	@Override
	public String getPhoneNumber() {
		
		return this.PhoneNumber;
	}

	@Override
	public void setPhoneNumber(String phoneNumber) throws UserException{
		//+525512345678
		String regex = "\\+52\\d{10}";
		if (Utilities.matchRegex(regex, phoneNumber)) {
			throw new UserException("Invalid user phonenumber, numbers unavalible");
		}
		this.PhoneNumber = phoneNumber;
		
	}

	@Override
	public Destination getCountry() {
		
		return this.Country;
	}

	@Override
	public void setCountry(Destination country) {
		
		this.Country=country;
	}

}