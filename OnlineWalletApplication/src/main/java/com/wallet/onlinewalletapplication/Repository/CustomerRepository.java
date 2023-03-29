package com.wallet.onlinewalletapplication.Repository;


import com.wallet.onlinewalletapplication.module.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    public Optional<Customer> findByEmail(String email);
}
