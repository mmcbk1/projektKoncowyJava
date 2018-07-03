package com.bkpw.projektkoncowy.controller;

import com.bkpw.projektkoncowy.entity.Company;
import com.bkpw.projektkoncowy.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping("/company")
    @ResponseStatus(HttpStatus.CREATED)
    public Company create(@RequestBody @Valid Company company) {
        return companyService.create(company);
    }

    @GetMapping("/companies")
    @ResponseStatus(HttpStatus.OK)
    public Page<Company> getAll(Pageable pageable) {
        return companyService.getAll(pageable);
    }

    @GetMapping("company/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Company getOne(@PathVariable Long id) {
        return companyService.getOne(id);
    }

    @DeleteMapping("company/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        companyService.delete(id);
    }

    @PutMapping("company/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Company update(@PathVariable Long id,
                          @RequestBody Company company) {
        return companyService.update(company, id);
    }


}
