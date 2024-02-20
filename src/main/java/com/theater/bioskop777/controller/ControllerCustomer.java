package com.theater.bioskop777.controller;

import com.theater.bioskop777.entity.Customer;
import com.theater.bioskop777.service.serviceimpl.CustomerServiceImpl;
import com.theater.bioskop777.util.ApiUrl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(ApiUrl.CUSTOMERS_URL)
public class ControllerCustomer {

    CustomerServiceImpl customerService;

    public ControllerCustomer(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer){

        return customerService.create(customer);
    }
}
