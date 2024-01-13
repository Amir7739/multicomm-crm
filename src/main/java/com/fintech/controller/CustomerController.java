package com.fintech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fintech.model.Customer;
import com.fintech.service.CustomerService;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    // get customers
    @GetMapping("/byComp/{companyId}")
    public List<Customer> getCustomersByCompany(@PathVariable Long companyId) {
        return customerService.getCustomersByCompanyId(companyId);
    }
}
