package com.bkpw.projektkoncowy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleUserDTO extends BaseEntityDTO{

    private String name;

    private String lastName;

    private String email;
}
