package com.wallet.onlinewalletapplication.controller;

import com.wallet.onlinewalletapplication.Service.BillServiceImpl;
import com.wallet.onlinewalletapplication.module.AmountDTO;
import com.wallet.onlinewalletapplication.module.BillPayment;
import com.wallet.onlinewalletapplication.module.Transaction;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BillPaymentController {
	
	@Autowired
	private BillServiceImpl billPaymentServicesImpl;

//	To Pay electricity Bill
	@PostMapping("/electricity")
	public String payElectricityBill(@Valid @RequestBody AmountDTO amountDTO ) {
		return billPaymentServicesImpl.electricityBillPayment(amountDTO.getAmount());
	}
	
//	To recharges mobile phone
	@PostMapping("/recharge")
	public String mobileRechargeBillPayment(@Valid @RequestBody AmountDTO amountDTO ) {
		return billPaymentServicesImpl.mobileRechargeBillPayment(amountDTO.getAmount());
	}
	
//	To get all bill payments
	@GetMapping("/bills")
	public List<BillPayment> getAllBillPayments() {
		return billPaymentServicesImpl.viewBillPayment();
	}
	
//	Get all transaction history
	@GetMapping("/transactions")
	public List<Transaction> getAllTransactions() {
		return billPaymentServicesImpl.getAllTransactions();
	}
}
