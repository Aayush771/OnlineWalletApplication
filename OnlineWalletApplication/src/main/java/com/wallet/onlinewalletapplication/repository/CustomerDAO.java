package com.wallet.onlinewalletapplication.repository;
import java.util.Optional;

import com.wallet.onlinewalletapplication.module.Customer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CustomerDAO extends JpaRepository<Customer, Integer>{
	
	public Optional<Customer> findByMobileNo(String mobileNo);
	public Optional<Customer> findByCustomerId(Integer customerId);
	
}
