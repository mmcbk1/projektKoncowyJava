package com.bkpw.projektkoncowy.controller;

import com.bkpw.projektkoncowy.dto.DepartmentDTO;
import com.bkpw.projektkoncowy.entity.Department;
import com.bkpw.projektkoncowy.service.CompanyService;
import com.bkpw.projektkoncowy.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    CompanyService companyService;


    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/department")
    @ResponseStatus(HttpStatus.CREATED)
    public Department create(@RequestBody DepartmentDTO departmentDTO) throws ParseException {

        Department department = convertToEntity(departmentDTO);
        return departmentService.create(department);
    }

    @GetMapping("/departments")
    @ResponseStatus(HttpStatus.OK)
    public List<Department> getAll() {
        return departmentService.getAll();
    }

    @GetMapping("department/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Department getOne(@PathVariable Long id) {
        return departmentService.getOne(id);
    }


    @DeleteMapping("department/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        departmentService.delete(id);
    }

    @PutMapping("department/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Department update(@PathVariable Long id, @RequestBody Department department) {
        return departmentService.update(department, id);
    }


    private Department convertToEntity(DepartmentDTO departmentDTO)  {
        Department department = modelMapper.map(departmentDTO, Department.class);
        department.setCompany(companyService.getOne(departmentDTO.getCompany_id()));
        return department;
    }


}
