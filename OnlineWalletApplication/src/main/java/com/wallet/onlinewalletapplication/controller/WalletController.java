package com.wallet.onlinewalletapplication.controller;

import com.wallet.onlinewalletapplication.Service.WalletServiceImpl;
import com.wallet.onlinewalletapplication.module.AmountDTO;
import com.wallet.onlinewalletapplication.module.Bank;
import com.wallet.onlinewalletapplication.module.FundTransferDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WalletController {
	
	@Autowired
	private WalletServiceImpl walletServiceImpl;
	
//	Add a Bank to wallet
	@PostMapping("/bank")
	public Bank addBankToWallet(@Valid @RequestBody Bank bank) {
		return walletServiceImpl.addBank(bank);
	}
	
//	Delete a Bank from wallet
	@DeleteMapping("/bank")
	public String deleteBankStringAccount() {
		return walletServiceImpl.removeBank();
	}
	
//	Get the Bank balance
	@GetMapping("/bankbalance")
	public double showBankBalance() {
		return walletServiceImpl.showBankBalance();
	}
	
//	Get the Wallet balance
	@GetMapping("/walletbalance")
	public double showWalletBalance() {
		return walletServiceImpl.showWalletBalance();
	}
	
//	Fund transfer from source mobile to target mobile
	@PostMapping("/transfer")
	public String fundTransferToWallet(@RequestBody FundTransferDTO fundTransferDTO) {
		return walletServiceImpl.fundTransterFromWalletToWallet(fundTransferDTO);
	}
	
//	Add money from bank to wallet
	@PostMapping(value = "/addmoney")
	public String addMoneyToWalletFromBank(@RequestBody AmountDTO addMoneyToWalletOrBankDTO) {
		
		return walletServiceImpl.addMoney(addMoneyToWalletOrBankDTO.getAmount());
	}
	
//	Deposit money to bank from wallet
	@PostMapping(value = "/deposit")
	public String depositMoneyToBankFromWallet(@RequestBody AmountDTO addMoneyToWalletOrBankDTO) {
		return walletServiceImpl.depositAmount(addMoneyToWalletOrBankDTO.getAmount());
	}
	

}
