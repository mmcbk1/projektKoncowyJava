package com.bkpw.projektkoncowy.dto;

import com.bkpw.projektkoncowy.entity.Address;
import com.bkpw.projektkoncowy.entity.BaseEntity;
import com.bkpw.projektkoncowy.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO extends BaseEntityDTO {


    private String name;

    private String shortName;

  /*  @OneToMany(
            mappedBy = "department")
    private List<User> users;
*/

    private Long company_id;

    private Address address;
}
