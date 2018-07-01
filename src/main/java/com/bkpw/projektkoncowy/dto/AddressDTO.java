package com.bkpw.projektkoncowy.dto;


import com.bkpw.projektkoncowy.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO extends BaseEntityDTO {


    private String street;

    private String city;

    private String state;

    private String country;

    private String postalCode;

    private String streetNumber;

}
