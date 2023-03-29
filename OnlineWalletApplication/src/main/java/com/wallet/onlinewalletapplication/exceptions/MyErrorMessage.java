package com.wallet.onlinewalletapplication.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class MyErrorMessage {
	
	private LocalDateTime localDateTime;
	
	private String message;
	
	private String detailString;
}
