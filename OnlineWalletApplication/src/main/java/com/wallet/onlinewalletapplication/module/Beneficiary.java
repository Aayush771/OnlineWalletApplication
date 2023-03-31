package com.wallet.onlinewalletapplication.module;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Beneficiary {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int beneficiaryId;

	private String name;
	
	private String mobileNumber;
	
	private Integer walletId;

	public Beneficiary(String name, String mobileNumber) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
	}

}
