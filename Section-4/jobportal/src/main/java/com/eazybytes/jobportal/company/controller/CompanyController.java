package com.eazybytes.jobportal.company.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    public ResponseEntity<String> getAllCompanies() {
        return ResponseEntity.ok().body("Companies List");
    }
}
