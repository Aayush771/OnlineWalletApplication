package com.wallet.onlinewalletapplication.repository;

import com.wallet.onlinewalletapplication.module.Bank;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankDAO extends JpaRepository<Bank, Integer>{

    @Override
    Optional<Bank> findById(Integer integer);
    Optional<Bank> findByMobileNumber(String mobileNumber);
}
