package com.wallet.onlinewalletapplication.Service;

import com.wallet.onlinewalletapplication.exceptions.BeneficiaryAlreadyExists;
import com.wallet.onlinewalletapplication.exceptions.NotFoundException;
import com.wallet.onlinewalletapplication.module.Beneficiary;

import java.util.List;
import java.util.Set;

public interface BeneficiaryService {
    public String addBeneficiary(String mobNo) throws NotFoundException, BeneficiaryAlreadyExists;

    public String deleteBeneficiary() throws NotFoundException;

    public List<Beneficiary> viewBeneficiary() throws NotFoundException;

    public List<Beneficiary> getAllBeneficiary() throws NotFoundException;
}
