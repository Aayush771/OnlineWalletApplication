package com.wallet.onlinewalletapplication.Service;

import com.wallet.onlinewalletapplication.exceptions.InsufficientAmountException;
import com.wallet.onlinewalletapplication.module.*;
import com.wallet.onlinewalletapplication.repository.BillPaymentDAO;
import com.wallet.onlinewalletapplication.repository.TransactionDAO;
import com.wallet.onlinewalletapplication.repository.WalletDAO;
import com.wallet.onlinewalletapplication.util.GetCurrentLoginUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillPaymentDAO billPaymentDAO;

    @Autowired
    private WalletDAO walletDAO;

    @Autowired
    private TransactionDAO transactionDAO;

    @Autowired
    private GetCurrentLoginUserDetails getCurrentLoginUserDetails;

    @Override
    public String electricityBillPayment(Double amount) {

        Wallet wallet = getCurrentLoginUserDetails.getCurrentUserWallet();

        if (wallet.getWalletBalance() <= amount) {
            throw new InsufficientAmountException("Insufficient amount in wallet");
        }

        BillPayment billPayment2 = new BillPayment(BillType.ELECTRICITY_BILL, amount, LocalDateTime.now(),
                wallet.getWalletId());

        wallet.setWalletBalance(wallet.getWalletBalance() - amount);

        Transaction myTransaction = new Transaction(TransactionType.WALLET_TO_ELECTRICITY_BILL, LocalDateTime.now(),
                amount, "Electricity bill is paid from wallet");
        wallet.getTransactions().add(myTransaction);

        transactionDAO.save(myTransaction);
        walletDAO.save(wallet);

        billPaymentDAO.save(billPayment2);

        return "Electricity bill of Rs : " + amount + " is paid successfully";
    }

    @Override
    public String mobileRechargeBillPayment(Double amount) {

        Wallet wallet = getCurrentLoginUserDetails.getCurrentUserWallet();

        if (wallet.getWalletBalance() < amount) {
            throw new InsufficientAmountException("Insufficient amount in wallet");
        }

        BillPayment billPayment2 = new BillPayment(BillType.MOBILE_RECHARGE, amount, LocalDateTime.now(),
                wallet.getWalletId());
        wallet.setWalletBalance(wallet.getWalletBalance() - amount);

        Transaction myTransaction = new Transaction(TransactionType.WALLET_TO_MOBILE_RECHARGE, LocalDateTime.now(),
                amount, "Mobile recharge bill is paid from wallet");

        wallet.getTransactions().add(myTransaction);

        transactionDAO.save(myTransaction);
        walletDAO.save(wallet);

        billPaymentDAO.save(billPayment2);

        return "Mobile recharge of Rs : " + amount + " is done successfully";
    }

    @Override
    public List<BillPayment> viewBillPayment() {

        Wallet wallet = getCurrentLoginUserDetails.getCurrentUserWallet();

        List<BillPayment> list = billPaymentDAO.findAllBillPaymentsByWalletId(wallet.getWalletId());

        return list;
    }

    @Override
    public List<Transaction> getAllTransactions() {

        Wallet wallet = getCurrentLoginUserDetails.getCurrentUserWallet();
        List<Transaction> transactions = transactionDAO.findAllTransactionsByWalletId(wallet.getWalletId());

        return transactions;
    }

}
