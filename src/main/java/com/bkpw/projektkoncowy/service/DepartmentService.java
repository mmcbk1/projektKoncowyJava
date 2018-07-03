package com.bkpw.projektkoncowy.service;

import com.bkpw.projektkoncowy.entity.Company;
import com.bkpw.projektkoncowy.entity.Department;
import com.bkpw.projektkoncowy.exception.NotFoundException;
import com.bkpw.projektkoncowy.repository.CompanyRepository;
import com.bkpw.projektkoncowy.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public Department update(Department department, Long id) {
        Optional<Department> OptionalDepartmentToUpdate = departmentRepository.findById(id);
        if (!OptionalDepartmentToUpdate.isPresent()) {
            throw new NotFoundException(String.format("Department with id %s not found", id));
        }
            department.setId(id);
        return departmentRepository.save(department);
    }


}
