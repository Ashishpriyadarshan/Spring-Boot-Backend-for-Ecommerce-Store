package com.eazybytes.service;

import com.eazybytes.model.Customer;
import com.eazybytes.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegistrationService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public Customer registerCustomer(Customer customer)
    {
       if(customerRepository.existsByEmail(customer.getEmail()))
           throw new RuntimeException("User already exists");

       String hashPwd = passwordEncoder.encode(customer.getPwd());
       customer.setPwd(hashPwd);
       Customer savedCustomer = customerRepository.save(customer);
       return savedCustomer;
    }

}
