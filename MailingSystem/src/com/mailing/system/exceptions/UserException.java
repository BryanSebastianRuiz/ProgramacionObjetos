package com.mailing.system.exceptions;

public class UserException extends Exception {
    public UserException(String message) {
        super(message); // This initializes the exception with the message which can be retrieved using getMessage()
    }
}
