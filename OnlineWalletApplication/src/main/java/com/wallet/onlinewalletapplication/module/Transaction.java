package com.wallet.onlinewalletapplication.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transactionId;
	
	private TransactionType transactionType;
	
	private LocalDateTime transactionDate;
	
	private double amount;
	
	private String description;
	
	private Integer walletId;

	public Transaction(TransactionType transactionType, LocalDateTime transactionDate, double amount,
			String description) {
		super();
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.description = description;
	}

}
