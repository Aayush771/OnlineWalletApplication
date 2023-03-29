package com.wallet.onlinewalletapplication.Service;

import com.wallet.onlinewalletapplication.exceptions.NotFoundException;
import com.wallet.onlinewalletapplication.module.Customer;

public interface CustomerService {
    public Customer createCustomer(Customer customer);

    public Customer updateCustomer(Customer customer) throws NotFoundException;

    public Customer deleteCustomer() throws NotFoundException;

    public Customer getCustomerDetails() throws NotFoundException;
}
