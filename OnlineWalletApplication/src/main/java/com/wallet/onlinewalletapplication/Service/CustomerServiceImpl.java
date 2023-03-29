package com.wallet.onlinewalletapplication.Service;

import com.wallet.onlinewalletapplication.exceptions.NotFoundException;
import com.wallet.onlinewalletapplication.exceptions.UserAlreadyExistWithMobileNumber;
import com.wallet.onlinewalletapplication.module.Customer;
import com.wallet.onlinewalletapplication.module.Wallet;
import com.wallet.onlinewalletapplication.repository.CustomerDAO;
import com.wallet.onlinewalletapplication.util.GetCurrentLoginUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private GetCurrentLoginUserDetails getCurrentLoginUserDetails;

    @Override
    public Customer createCustomer(Customer customer) {

        Optional<Customer> opt = customerDAO.findByMobileNo(customer.getMobileNo());

        if (opt.isPresent()) {
            throw new UserAlreadyExistWithMobileNumber("User already exist with this mobile number");
        }

        Wallet wallet = new Wallet();
        wallet.setWalletBalance(0.0);
        wallet.setCustomer(customer);

        customer.setWallet(wallet);
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

        return customerDAO.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {

        if (getCurrentLoginUserDetails.checkLogin()) {
            customerDAO.save(customer);
            return customer;
        } else {
            throw new NotFoundException("No user found.. try login first");
        }

    }

    @Override
    public Customer deleteCustomer() {

        if (getCurrentLoginUserDetails.checkLogin()) {
            Customer customer = getCurrentLoginUserDetails.getCurrentCustomer();
            System.out.println("Before");
            customerDAO.delete(customer);
            System.out.println("Before");
            return customer;

        } else {
            throw new NotFoundException("No user found.. try login first");
        }

    }

    @Override
    public Customer getCustomerDetails() {

        if (getCurrentLoginUserDetails.checkLogin()) {

            return getCurrentLoginUserDetails.getCurrentCustomer();

        } else {
            throw new NotFoundException("No user found.. try login first");
        }

    }

}
