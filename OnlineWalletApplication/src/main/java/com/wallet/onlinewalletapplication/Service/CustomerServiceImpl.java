package com.wallet.onlinewalletapplication.Service;

import com.wallet.onlinewalletapplication.Entity.Customer;
import com.wallet.onlinewalletapplication.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) throws ClassNotFoundException {
        Optional<Customer> customer1 = customerRepository.findByEmail(customer.getEmail());
        if (customer1.isPresent()) {
            throw new ClassNotFoundException("Customer is already Exist with this Email id " + customer.getEmail());
        } else return customerRepository.save(customer);


    }
}
