package com.wallet.onlinewalletapplication.Service;

import com.wallet.onlinewalletapplication.exceptions.InsufficientAmountException;
import com.wallet.onlinewalletapplication.exceptions.NotFoundException;
import com.wallet.onlinewalletapplication.module.Bank;
import com.wallet.onlinewalletapplication.module.FundTransferDTO;

public interface WalletService {
    public Bank addBank(Bank bank) ;

    public String removeBank() throws NotFoundException;

    public double showBankBalance() throws NotFoundException;

    public double showWalletBalance() throws NotFoundException;

    public String fundTransterFromWalletToWallet(FundTransferDTO fundTransferDTO) throws InsufficientAmountException;

    public String depositAmount(Double amount) throws InsufficientAmountException;

    public String addMoney(Double amount) throws InsufficientAmountException;

}
