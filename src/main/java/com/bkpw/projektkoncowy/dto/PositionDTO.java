package com.bkpw.projektkoncowy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionDTO extends BaseEntityDTO {

    private String name;
    private Long departmentId;
}
