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
@NoArgsConstructor
@AllArgsConstructor
public class BillPayment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer billId;
	
	private BillType billType;
	
	private double amount;
	
	private LocalDateTime paymentDateTime;
	
	private Integer walletId;

	public BillPayment(BillType billType, double amount, LocalDateTime paymentDateTime, Integer walletId) {
		super();
		this.billType = billType;
		this.amount = amount;
		this.paymentDateTime = paymentDateTime;
		this.walletId = walletId;
	}
	
}
