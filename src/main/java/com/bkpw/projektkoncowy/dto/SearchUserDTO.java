package com.bkpw.projektkoncowy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchUserDTO{

    private Long id;

    private String name;

    private String lastName;

    private String email;

    private String companyName;

    private Long companyId;

    private String positionName;

    private Long departmentId;

/*    public SearchUserDTO(Long id, String name, String lastName, String email, String companyName, Long companyId, String positionName, Long departmentId) {
        this.id=id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.companyName = companyName;
        this.companyId = companyId;
        this.positionName = positionName;
        this.departmentId = departmentId;
    }*/
}
