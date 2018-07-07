package com.bkpw.projektkoncowy.dto;

import com.bkpw.projektkoncowy.entity.Address;
import com.bkpw.projektkoncowy.entity.BaseEntity;
import com.bkpw.projektkoncowy.entity.Company;
import com.bkpw.projektkoncowy.entity.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO extends BaseEntityDTO {



    private String name;

    private String shortName;

    private Long company_id;

    private List<Long> users;

    private Address address;

    private String companyName;

    private List<Position> positions;
}
