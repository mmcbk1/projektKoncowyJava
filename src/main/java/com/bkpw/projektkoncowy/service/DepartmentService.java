package com.bkpw.projektkoncowy.service;

import com.bkpw.projektkoncowy.entity.Company;
import com.bkpw.projektkoncowy.entity.Department;
import com.bkpw.projektkoncowy.entity.User;
import com.bkpw.projektkoncowy.exception.BindingResultException;
import com.bkpw.projektkoncowy.exception.NotFoundException;
import com.bkpw.projektkoncowy.repository.CompanyRepository;
import com.bkpw.projektkoncowy.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements GenericService<Department> {

    @Autowired
    DepartmentRepository departmentRepository;

    public Department create(Department department) {
        return departmentRepository.save(department);
    }

    public Page<Department> getAll(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }

    public Department getOne(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        if (!department.isPresent()) {
            throw new NotFoundException(String.format("Department with id %s not found", id));
        }

        return department.get();
    }

    public void delete(Long id) {
        if (!departmentRepository.existsById(id)) {
            throw new NotFoundException(String.format("Department with id %s not found", id));
        }
        departmentRepository.deleteById(id);
    }

    public Department update(Department department, Long id, BindingResult bindingResult) {
        validate(department, getOne(id).getName(), bindingResult);
        Optional<Department> OptionalDepartmentToUpdate = departmentRepository.findById(id);
        if (!OptionalDepartmentToUpdate.isPresent()) {
            throw new NotFoundException(String.format("Department with id %s not found", id));
        }
            department.setId(id);
        return departmentRepository.save(department);
    }

    private void validate(Department department, String currentDepName, BindingResult bindingResult) {
        if (!department.getName().equals(currentDepName)
                && departmentRepository.existsByName(department.getName())) {
            bindingResult.addError(
                    new FieldError("department", "field",
                            String.format("Department with this name %s already exists", department.getName())));
        }
        if (bindingResult.hasErrors()) {
            throw new BindingResultException(bindingResult);
        }
    }

}
