package com.wallet.onlinewalletapplication.repository;

import java.util.List;
import java.util.Optional;

import com.wallet.onlinewalletapplication.module.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDAO extends JpaRepository<Transaction, Integer>{

	public List<Transaction> findAllTransactionsByWalletId(Integer id);
	
}
