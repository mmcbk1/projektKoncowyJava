package com.bkpw.projektkoncowy.dto;


import com.bkpw.projektkoncowy.entity.Address;
import com.bkpw.projektkoncowy.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO extends BaseEntityDTO {


    private String name;

    private String nip;

    private String phone;

    private String fax;

    private Address address;

    private List<Department> departments;

}
