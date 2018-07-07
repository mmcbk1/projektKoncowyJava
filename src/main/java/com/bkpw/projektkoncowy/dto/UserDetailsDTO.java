package com.bkpw.projektkoncowy.dto;

import com.bkpw.projektkoncowy.entity.Address;
import com.bkpw.projektkoncowy.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDTO extends BaseEntityDTO {

    private String name;

    private String lastName;

    private String email;

    private Gender gender;

    private Date birthDate;

    private Integer salary;

    private Date hireDate;

    private Address address;

    // private Set<Role> userRoles;

    private DepartmentDTO DepartmentDTO;

}
