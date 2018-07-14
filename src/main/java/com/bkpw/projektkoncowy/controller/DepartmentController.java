package com.bkpw.projektkoncowy.controller;

import com.bkpw.projektkoncowy.dto.DepartmentDTO;
import com.bkpw.projektkoncowy.dto.SimpleUserDTO;
import com.bkpw.projektkoncowy.entity.Department;
import com.bkpw.projektkoncowy.entity.User;
import com.bkpw.projektkoncowy.repository.DepartmentRepository;
import com.bkpw.projektkoncowy.repository.PositionRepository;
import com.bkpw.projektkoncowy.repository.UserRepository;
import com.bkpw.projektkoncowy.service.CompanyService;
import com.bkpw.projektkoncowy.service.DepartmentService;
import com.bkpw.projektkoncowy.service.PositionService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toList;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    CompanyService companyService;

    @Autowired
    PositionService positionService;

    @Autowired
    PositionRepository positionRepository;

    @Autowired
    UserRepository userRepository;


    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/department")
    @ResponseStatus(HttpStatus.CREATED)
    public Department create(@RequestBody @Valid DepartmentDTO departmentDTO,
                             BindingResult bindingResult) {
        Department department = convertToEntity(departmentDTO);
        return departmentService.create(department, bindingResult);
    }

    @GetMapping("/departments")
    @ResponseStatus(HttpStatus.OK)
    public Page<Department> getAll(Pageable pageable) {
        return departmentService.getAll(pageable);
    }

    @GetMapping("/search/departments")
    @ResponseStatus(HttpStatus.OK)
    public PageImpl search(
            @RequestParam(value = "name", required = false, defaultValue = "") String name,
            @RequestParam(value = "shortName", required = false, defaultValue = "") String shortName,
            @RequestParam(value = "companyName", required = false, defaultValue = "") String companyName,
            Pageable pageable) {

        Page<Department> result = departmentService.search(name, shortName, companyName, pageable);

        int totalElements = (int) result.getTotalElements();

       return new PageImpl<>(result
                .stream()
                .map(department -> new DepartmentDTO(
                        department.getId(),
                        department.getName(),
                        department.getShortName(),
                        department.getCompany().getId(),
                        department.getCompany().getName()
                ))
                .collect(Collectors.toList()), pageable, totalElements);

    }

    @GetMapping("department/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DepartmentDTO getOne(@PathVariable Long id) {
        DepartmentDTO departmentDTO = entityToDTO(departmentService.getOne(id));
        departmentDTO.setCompanyName(departmentService.getOne(id).getCompany().getName());
        departmentDTO.setPositions(positionRepository.findByDepartment_Id(id));
        List<User> users = userRepository.findAll();
        Type listType = new TypeToken<List<SimpleUserDTO>>() {
        }.getType();
        List<SimpleUserDTO> lista = modelMapper.map(users, listType);
        departmentDTO.setUsers(lista);
        if (departmentDTO.getUsers() == null) {
            departmentDTO.setUsers(new ArrayList<>());
        }

        if (departmentDTO.getPositions() == null) {
            departmentDTO.setPositions(new ArrayList<>());
        }
        return departmentDTO;
    }


    @DeleteMapping("department/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        departmentService.delete(id);
    }

    @PutMapping("department/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Department update(@PathVariable Long id,
                             @RequestBody @Valid Department department,
                             BindingResult bindingResult) {
        return departmentService.update(department, id, bindingResult);
    }


    private Department convertToEntity(DepartmentDTO departmentDTO) {
        Department department = modelMapper.map(departmentDTO, Department.class);
        department.setCompany(companyService.getOne(departmentDTO.getCompany_id()));
        return department;
    }

    private DepartmentDTO entityToDTO(Department department) {
        DepartmentDTO departmentDTO = modelMapper.map(department, DepartmentDTO.class);
        return departmentDTO;
    }


}
