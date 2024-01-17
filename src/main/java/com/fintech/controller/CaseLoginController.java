package com.fintech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.fintech.model.CaseLogin;
import com.fintech.service.CaseLoginService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CaseLoginController {

    @Autowired
    private CaseLoginService caseLoginService;

    @PostMapping("/savecaselogin")
    public ResponseEntity<?> createCaseLogin(
            @RequestParam("files") MultipartFile[] files,
            @RequestParam("dateOfLogin") String dateOfLogin,
            @RequestParam("employeeIdOfCaseOwner") String employeeIdOfCaseOwner,
            @RequestParam("employeeName") String employeeName,
            @RequestParam("managerName") String managerName,
            @RequestParam("employementType") String employementType,
            @RequestParam("branchName") String branchName,
            @RequestParam("customerName") String customerName,
            @RequestParam("customerContact") String customerContact,
            @RequestParam("mailId") String mailId,
            @RequestParam("customerPan") String customerPan,
            @RequestParam("customerDateOfBirth") String customerDateOfBirth,
            @RequestParam("customerPermanentAddress") String customerPermanentAddress,
            @RequestParam("officeAddressWithPin") String officeAddressWithPin,
            @RequestParam("state") String state,
            @RequestParam("city") String city,
            @RequestParam("customerOccupation") String customerOccupation,
            @RequestParam("requiredLoanType") String requiredLoanType,
            @RequestParam("requiredLoanAmount") String requiredLoanAmount,
            @RequestParam("latestCIBILScore") String latestCIBILScore,
            @RequestParam("bankingPassAndOtherDocPass") String bankingPassAndOtherDocPass,
            @RequestParam("toBeLoggedInFromWhichLender") String toBeLoggedInFromWhichLender,
            @RequestParam("remarks") String remarks) {
        try {
            // Create a new CaseLogin and set the form data
            CaseLogin caseLogin = new CaseLogin();
            caseLogin.setDateOfLogin(dateOfLogin);
            caseLogin.setEmployeeIdOfCaseOwner(employeeIdOfCaseOwner);
            caseLogin.setEmployeeName(employeeName);
            caseLogin.setManagerName(managerName);
            caseLogin.setEmployementType(employementType);
            caseLogin.setBranchName(branchName);
            caseLogin.setCustomerName(customerName);
            caseLogin.setCustomerContact(customerContact);
            caseLogin.setMailId(mailId);
            caseLogin.setCustomerPan(customerPan);
            caseLogin.setCustomerDateOfBirth(customerDateOfBirth);
            caseLogin.setCustomerPermanentAddress(customerPermanentAddress);
            caseLogin.setOfficeAddressWithPin(officeAddressWithPin);
            caseLogin.setState(state);
            caseLogin.setCity(city);
            caseLogin.setCustomerOccupation(customerOccupation);
            caseLogin.setRequiredLoanType(requiredLoanType);
            caseLogin.setRequiredLoanAmount(requiredLoanAmount);
            caseLogin.setLatestCIBILScore(latestCIBILScore);
            caseLogin.setBankingPassAndOtherDocPass(bankingPassAndOtherDocPass);
            caseLogin.setToBeLoggedInFromWhichLender(toBeLoggedInFromWhichLender);
            caseLogin.setRemarks(remarks);

            // Save the CaseLogin object
            CaseLogin savedCaseLogin = caseLoginService.saveCaseLogin(caseLogin);

            // Save files to the database
            List<CaseLogin> savedFiles = new ArrayList<>();
            for (MultipartFile file : files) {
                try {
                    // Create a new CaseLogin for each file and set the file name
                    CaseLogin fileLogin = new CaseLogin();
                    fileLogin.setUploadFiles(file.getOriginalFilename());

                    // Save the file to the database and add to the list of saved files
                    CaseLogin savedFile = caseLoginService.saveFile(fileLogin);
                    savedFiles.add(savedFile);

                    // You may also want to save the actual file content to a storage location
                    // For simplicity, this example only saves the file metadata to the database
                } catch (Exception e) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body("Failed to upload file: " + file.getOriginalFilename());
                }
            }

            return ResponseEntity.ok("Case Login and Files uploaded successfully. Saved Case Login: " + savedCaseLogin
                    + ". Saved Files: " + savedFiles);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to save Case Login and Files: " + e.getMessage());
        }
    }
}
