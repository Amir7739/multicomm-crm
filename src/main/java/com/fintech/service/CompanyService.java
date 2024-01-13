package com.fintech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fintech.model.Company;
import com.fintech.repo.CompanyRepo;
@Service
public class CompanyService {
    @Autowired
    private CompanyRepo companyRepo;

    //  company details method
    public Company saveCompanyDetails(Company company) {
        return companyRepo.save(company);
    }
}
