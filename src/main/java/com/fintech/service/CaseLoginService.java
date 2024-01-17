package com.fintech.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fintech.model.CaseLogin;

import com.fintech.repo.CaseLoginRepo;


@Service
public class CaseLoginService {

    @Autowired
    private CaseLoginRepo caseLoginRepo;
    
    
    // get all caselogin
    public List<CaseLogin> getAllCaseLogin() {
        return caseLoginRepo.findAll();
    }

    // add caselogin
    public CaseLogin saveCaseLogin(CaseLogin caseLogin) {
        return caseLoginRepo.save(caseLogin);
    }

    

    public CaseLogin getCaseLoginById(Long caseloginId) {
        Optional<CaseLogin> optionalCaseLogin = caseLoginRepo.findById(caseloginId);
        return optionalCaseLogin.orElse(null); // or throw an exception if not found
    }

}
