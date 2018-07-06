package com.bkpw.projektkoncowy.service;

import com.bkpw.projektkoncowy.entity.Company;
import com.bkpw.projektkoncowy.entity.User;
import com.bkpw.projektkoncowy.exception.BindingResultException;
import com.bkpw.projektkoncowy.exception.NotFoundException;
import com.bkpw.projektkoncowy.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements GenericService<Company> {

    @Autowired
    CompanyRepository companyRepository;

    public Company create(Company company, BindingResult bindingResult) {
        validate(company,null,bindingResult);
        return companyRepository.save(company);
    }


    public Page<Company> getAll(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    public Company getOne(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        if (!company.isPresent()) {
            throw new NotFoundException(String.format("Company with id %s not found", id));
        }

        return company.get();
    }

    public void delete(Long id) {
        if (!companyRepository.existsById(id)) {
            throw new NotFoundException(String.format("Company with id %s not found", id));
        }
        companyRepository.deleteById(id);
    }

    public Company update(Company company, Long id, BindingResult bindingResult) {
        validate(company,getOne(id).getName(),bindingResult);
        Optional<Company> OptionalCompanyToUpdate = companyRepository.findById(id);
        if (!OptionalCompanyToUpdate.isPresent()) {
            throw new NotFoundException(String.format("Company with id %s not found", id));
        }
        company.setId(id);
        return companyRepository.save(company);
    }


    private void validate(Company company, String currentCompName, BindingResult bindingResult) {
        if (!company.getName().equals(currentCompName)
                && companyRepository.existsByName(company.getName())) {
            bindingResult.addError(
                    new FieldError("company", "name",
                            String.format("Company with name %s already exists", company.getName())));
        }
        if (bindingResult.hasErrors()) {
            throw new BindingResultException(bindingResult);
        }
    }

}
