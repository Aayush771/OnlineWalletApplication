package com.wallet.onlinewalletapplication.module;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer walletId ;

	private Double walletBalance;
	
	@OneToOne(cascade =  CascadeType.ALL)
	private Customer customer;

	@OneToOne(cascade = CascadeType.ALL)
	private Bank bank;
	
	@JsonIgnore
	@Embedded
	@ElementCollection
	private Set<Beneficiary> beneficiary = new HashSet<>();
	
	@JsonIgnore
	@OneToMany
	@JoinColumn(name = "walletId", referencedColumnName = "walletId")
	private List<Transaction> transactions;


		
}
