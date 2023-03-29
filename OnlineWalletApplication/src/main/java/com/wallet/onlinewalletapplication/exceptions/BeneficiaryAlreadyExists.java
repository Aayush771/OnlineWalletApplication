package com.wallet.onlinewalletapplication.exceptions;


public class BeneficiaryAlreadyExists extends RuntimeException{

	public BeneficiaryAlreadyExists() {
		
	}
	
	public BeneficiaryAlreadyExists(String message) {
		super(message);
	}
}