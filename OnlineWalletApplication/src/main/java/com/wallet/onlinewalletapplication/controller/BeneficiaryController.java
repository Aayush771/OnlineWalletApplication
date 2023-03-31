package com.wallet.onlinewalletapplication.controller;

import java.util.List;
import java.util.Set;

import com.wallet.onlinewalletapplication.Service.BeneficiaryServiceImpl;
import com.wallet.onlinewalletapplication.module.Beneficiary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class BeneficiaryController {

	@Autowired
	private BeneficiaryServiceImpl beneficiaryServiceImpl;

//	Add Beneficiary to Wallet by passing this object
//	{
//		"name":"Jay",
//		"mobileNumber":"9981595557"
//	}

	@PatchMapping(value = "/beneficiary/{id}")
	public String addBeneficiaryInMyWallet(@PathVariable(value = "id") String MobNo) {
		return beneficiaryServiceImpl.addBeneficiary(MobNo);
	}

//	Delete Beneficiary to from wallet by passing this object
//	{
//	"name":"Jay",
//	"mobileNumber":"9981595557"
//}

	@DeleteMapping(value = "/beneficiary")
	public String deleteBeneficiaryInMyWallet() {
		return beneficiaryServiceImpl.deleteBeneficiary();
	}

//	Get Beneficiary to Wallet
//	By passing mobile number

	@GetMapping(value = "/beneficiary")
	public List<Beneficiary> viewBeneficiaryInMyWallet() {
		return beneficiaryServiceImpl.viewBeneficiary();
	}

//	Get All Beneficiaries to Wallet
	@GetMapping(value = "/beneficiaries")
	public List<Beneficiary> getAllBeneficiaryInMyWallet() {
		return beneficiaryServiceImpl.getAllBeneficiary();
	}

}
