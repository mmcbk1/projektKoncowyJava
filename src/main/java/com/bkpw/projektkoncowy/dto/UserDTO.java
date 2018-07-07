package com.bkpw.projektkoncowy.dto;

import com.bkpw.projektkoncowy.entity.Address;
import com.bkpw.projektkoncowy.entity.Gender;
import com.bkpw.projektkoncowy.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO extends BaseEntityDTO {

    private String name;

    private String lastName;

    private String email;

    private Gender gender;

    private Date birthDate;

    private Integer salary;

    private Date hireDate;

    private Address address;

   // private Set<Role> userRoles;

    private Long positionId;

    private String password;

    private String repeatPassword;

}
