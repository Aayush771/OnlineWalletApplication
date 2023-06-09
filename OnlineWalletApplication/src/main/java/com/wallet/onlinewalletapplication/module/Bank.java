package com.wallet.onlinewalletapplication.module;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank {
	
	@Id
	private Integer accountNumber;

	@NotNull
	private String mobileNumber;
	
	@NotNull
	private String ifscCode;
	
	@NotNull
	private String bankName;
	
	@NotNull
	private double bankBalance;
	
	private Integer walletId;
	
}
