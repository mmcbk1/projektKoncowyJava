package com.bkpw.projektkoncowy.dto;

import com.bkpw.projektkoncowy.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    private Long id;

    private String name;

    private String shortName;

    private Long company_id;

    private List<SimpleUserDTO> users;

    private Address address;

    private String companyName;

    private List<Position> positions;

    public DepartmentDTO(Long id, String name, String shortName, Long company_id, String companyName) {
        this.id=id;
        this.name = name;
        this.shortName = shortName;
        this.company_id = company_id;
        this.companyName = companyName;
    }
}
