package com.wallet.onlinewalletapplication.Service;

import com.wallet.onlinewalletapplication.module.Customer;

public interface CustomerService {
    public Customer saveCustomer(Customer customer) throws ClassNotFoundException;
}
