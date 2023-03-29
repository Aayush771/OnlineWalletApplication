package com.wallet.onlinewalletapplication.module;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class Wallet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer walletId ;

	private Double walletBalance;
	
	@OneToOne(cascade =  CascadeType.ALL)
	private Customer customer;

	@OneToOne(cascade = CascadeType.ALL)
	private Bank bank;
	
//	@JsonIgnore
//	@Embedded
//	private List<Beneficiary> beneficiary = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany
	@JoinColumn(name = "walletId", referencedColumnName = "walletId")
	private List<Transaction> transactions;


		
}
