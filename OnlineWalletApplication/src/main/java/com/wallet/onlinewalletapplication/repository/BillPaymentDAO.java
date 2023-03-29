package com.wallet.onlinewalletapplication.repository;

import java.util.List;

import com.wallet.onlinewalletapplication.module.BillPayment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BillPaymentDAO extends JpaRepository<BillPayment, Integer>{

	public List<BillPayment> findAllBillPaymentsByWalletId(Integer id);

}

