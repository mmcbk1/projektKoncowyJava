package com.bkpw.projektkoncowy.service;

import com.bkpw.projektkoncowy.entity.Company;
import com.bkpw.projektkoncowy.exception.NotFoundException;
import com.bkpw.projektkoncowy.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;
    public Company create(Company company){
        return companyRepository.save(company);
    }

    public List<Company> getAll(){
        return companyRepository.findAll();
    }

    public Company getOne(Long id){
        Optional<Company> company =companyRepository.findById(id);
        if (!company.isPresent()) {
            throw new NotFoundException(String.format("Company with id %s not found", id));
        }

        return company.get();
    }

    public void delete(Long id){
        if (!companyRepository.existsById(id)) {
            throw new NotFoundException(String.format("Company with id %s not found", id));
        }
        companyRepository.deleteById(id);
    }

    public Company update(Company company,Long id){
        Optional<Company> OptionalCompanyToUpdate =companyRepository.findById(id);
        if (!OptionalCompanyToUpdate.isPresent()) {
            throw new NotFoundException(String.format("Company with id %s not found", id));
        }
        Company companyToUpdate=OptionalCompanyToUpdate.get();

        companyToUpdate.setName(company.getName());
        companyToUpdate.setFax(company.getFax());
        companyToUpdate.setNip(company.getNip());
        companyToUpdate.setPhone(company.getPhone());
        companyToUpdate.setAddress(company.getAddress());
        companyToUpdate.setDepartments(company.getDepartments());

        return companyRepository.save(companyToUpdate);
    }








}
