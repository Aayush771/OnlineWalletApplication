package com.wallet.onlinewalletapplication.repository;

import java.util.List;
import java.util.Optional;

import com.wallet.onlinewalletapplication.module.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BeneficiaryDAO extends JpaRepository<Beneficiary, Integer>{
	
	public Optional<Beneficiary>  findByMobileNumber(String mobileNumber);
	
	public List<Beneficiary> findByWalletId(Integer id);
}
