package com.bkpw.projektkoncowy.controller;

import com.bkpw.projektkoncowy.entity.Company;
import com.bkpw.projektkoncowy.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class CompanyController {

    @Autowired
    CompanyService companyService;


    @PostMapping("/company")
    @ResponseStatus(HttpStatus.CREATED)
    public Company create(@RequestBody Company company) {
        return companyService.create(company);
    }

    @GetMapping("/companies")
    @ResponseStatus(HttpStatus.OK)
    public List<Company> getAll(){
        return companyService.getAll();
    }

    @GetMapping("company/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Company getOne(@PathVariable Long id){
        return companyService.getOne(id);
    }


    @DeleteMapping("company/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        companyService.delete(id);
    }

    @PutMapping("company/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @RequestBody Company company){
        companyService.update(company,id);
    }


}
