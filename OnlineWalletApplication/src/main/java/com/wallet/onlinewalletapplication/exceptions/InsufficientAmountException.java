package com.wallet.onlinewalletapplication.exceptions;

public class InsufficientAmountException extends RuntimeException{

	public InsufficientAmountException() {
		
	}
	
	public InsufficientAmountException(String message) {
		super(message);
	}
}
