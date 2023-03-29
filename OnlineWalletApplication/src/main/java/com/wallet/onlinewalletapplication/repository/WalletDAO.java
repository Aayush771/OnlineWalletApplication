package com.wallet.onlinewalletapplication.repository;
import java.util.Optional;

import com.wallet.onlinewalletapplication.module.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WalletDAO extends JpaRepository<Wallet, Integer>{

    @Override
    Optional<Wallet> findById(Integer integer);



}
