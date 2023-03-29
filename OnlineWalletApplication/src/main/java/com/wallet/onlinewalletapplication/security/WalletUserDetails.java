package com.wallet.onlinewalletapplication.security;

import com.wallet.onlinewalletapplication.module.Customer;
import com.wallet.onlinewalletapplication.repository.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalletUserDetails implements UserDetailsService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> customer = customerDAO.findCustomerByEmail(username);
        if (customer.isEmpty()) {
            throw new UsernameNotFoundException("User details not found for the user : " + username);
        }
        return new SecurityCustomer(customer.get());
    }

}
