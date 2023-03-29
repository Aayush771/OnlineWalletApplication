package com.wallet.onlinewalletapplication.exceptions;


public class UserAlreadyExistWithMobileNumber extends RuntimeException{

	public UserAlreadyExistWithMobileNumber() {
		
	}
	
	public UserAlreadyExistWithMobileNumber(String message) {
		super(message);
	}
}