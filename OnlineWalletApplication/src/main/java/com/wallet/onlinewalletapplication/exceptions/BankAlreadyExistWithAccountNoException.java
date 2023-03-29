package com.wallet.onlinewalletapplication.exceptions;

public class BankAlreadyExistWithAccountNoException extends RuntimeException{

	public BankAlreadyExistWithAccountNoException() {
		
	}
	
	public BankAlreadyExistWithAccountNoException(String message) {
		super(message);
	}
}
