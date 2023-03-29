package com.wallet.onlinewalletapplication.Service;

import com.wallet.onlinewalletapplication.module.BillPayment;
import com.wallet.onlinewalletapplication.module.Transaction;

import java.util.List;

public interface BillService {
    public String electricityBillPayment(Double amount);

    public String mobileRechargeBillPayment(Double amount);

    public List<BillPayment> viewBillPayment();

    public List<Transaction> getAllTransactions();
}
