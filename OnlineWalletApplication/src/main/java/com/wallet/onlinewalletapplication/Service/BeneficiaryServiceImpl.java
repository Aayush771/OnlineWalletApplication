package com.wallet.onlinewalletapplication.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.wallet.onlinewalletapplication.exceptions.BeneficiaryAlreadyExists;
import com.wallet.onlinewalletapplication.exceptions.NotFoundException;
import com.wallet.onlinewalletapplication.module.Beneficiary;
import com.wallet.onlinewalletapplication.module.Customer;
import com.wallet.onlinewalletapplication.module.Wallet;
import com.wallet.onlinewalletapplication.repository.BeneficiaryDAO;
import com.wallet.onlinewalletapplication.repository.CustomerDAO;
import com.wallet.onlinewalletapplication.repository.WalletDAO;
import com.wallet.onlinewalletapplication.util.GetCurrentLoginUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private WalletDAO walletDAO;

	@Autowired
	private BeneficiaryDAO beneficiaryDAO;

	@Autowired
	private GetCurrentLoginUserDetails getCurrentLoginUserDetails;

	@Override
	public String addBeneficiary(String mobNo) {

		Wallet wallet = getCurrentLoginUserDetails.getCurrentUserWallet();

		Optional<Customer> opt = customerDAO.findByMobileNo(mobNo);
		Beneficiary beneficiary = new Beneficiary();
		if (!opt.isPresent()) {
			throw new NotFoundException("Customer does not exists...");
		}{

			int id = wallet.getWalletId();
			beneficiary.setWalletId(id);
			beneficiary.setMobileNumber(opt.get().getMobileNo());
			beneficiary.setName(opt.get().getName());
			beneficiaryDAO.save(beneficiary);
		}



		return beneficiary.toString();
	}

	@Override
	public String deleteBeneficiary() {

		Wallet wallet = getCurrentLoginUserDetails.getCurrentUserWallet();

		List<Beneficiary> beneficiary = beneficiaryDAO.findByWalletId(wallet.getWalletId());
		 if(beneficiary.size() != 0){
			 beneficiaryDAO.delete(beneficiary.get(0));
			 return beneficiary.get(0).toString();
		 }else throw new NotFoundException("Beneficiary does not exists...");
	}

	@Override
	public List<Beneficiary> viewBeneficiary() {

		if (getCurrentLoginUserDetails.checkLogin()) {

			int id = getCurrentLoginUserDetails.getCurrentCustomer().getWallet().getWalletId();
			return beneficiaryDAO.findByWalletId(id);

		} else {
			throw new NotFoundException("No user found.. try login first");
		}
	}

	@Override
	public List<Beneficiary> getAllBeneficiary() {

		List<Beneficiary> beneficiaries = beneficiaryDAO.findAll();

		if (beneficiaries.size() == 0) {
			throw new NotFoundException("Beneficiaries not found");
		}

		return beneficiaries;
	}

}