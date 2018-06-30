package com.bkpw.projektkoncowy.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "addresses")
public class Address extends BaseEntity{


    @Column(name = "street")
    private String street;


    @Column(name = "city")
    private String city;


    @Column(name = "state")
    private String state;


    @Column(name = "country")
    private String country;


    @Column(name = "postal_code")
    private String postalCode;


    @Column(name = "street_number")
    private String streetNumber;



}
