package com.bkpw.projektkoncowy.controller;

import com.bkpw.projektkoncowy.entity.Department;
import com.bkpw.projektkoncowy.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/department")
    @ResponseStatus(HttpStatus.CREATED)
    public Department create(@RequestBody String params) {

        GsonJsonParser gsonJsonParser = new GsonJsonParser();
        Map departmentMap = gsonJsonParser.parseMap(params);
        Department department = new Department();
        System.out.println(departmentMap);
        return departmentService.create(department);
    }

    @GetMapping("/departments")
    @ResponseStatus(HttpStatus.OK)
    public List<Department> getAll(){
        return departmentService.getAll();
    }

    @GetMapping("department/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Department getOne(@PathVariable Long id){
        return departmentService.getOne(id);
    }


    @DeleteMapping("department/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        departmentService.delete(id);
    }

    @PutMapping("department/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @RequestBody Department department){
        departmentService.update(department,id);
    }



}
