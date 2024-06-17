package com.mailing.system.models;

import com.mailing.system.exceptions.UserException;

public class User {
    private String fullName;
    private String address;
    private String phoneNumber;
    private String email;

    public User(String fullName, String address, String phoneNumber, String email) throws UserException {
        setFullName(fullName);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }

    public String getFullName() { // Define the getter method to get the full name
        return fullName;
    }

    public void setFullName(String fullName) throws UserException {
        if (!fullName.matches("^[a-zA-Z\\s]+$")) {
            throw new UserException("Invalid full name. It should contain only letters and spaces.");
        }
        this.fullName = fullName;
    }

    public String getAddress() { // Define the getter method to obtain the address
        return address;
    }

    public void setAddress(String address) throws UserException { // Defines the setter method to set the address and throws a UserException if it is invalid
        if (!address.matches(".*\\d{5}.*(OAX|QROO|MOR|QRO|SIN).*")) {
            throw new UserException("Invalid address. It must contain a 5-digit postal code and a valid state code.");
        }
        this.address = address;
    }

    public String getPhoneNumber() { // Define the getter method to get the phone number
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws UserException { // Defines the setter method to set the phone number and throws a UserException if it is invalid
        if (!phoneNumber.matches("\\+52\\d{10}")) {
            throw new UserException("Invalid phone number. It must start with +52 and be followed by 10 digits.");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() { // Define the getter method to get the email
        return email;
    }

    public void setEmail(String email) throws UserException { // Defines the setter method to set the email and throws a UserException if it is invalid
        if (!email.endsWith("@gmail.com")) {
            throw new UserException("Invalid email. It must be a @gmail.com email.");
        }
        this.email = email;
    }
}
