package com.theater.bioskop777.service.serviceimpl;

import com.theater.bioskop777.entity.Customer;
import com.theater.bioskop777.repository.CustomerRepository;
import com.theater.bioskop777.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }
}
