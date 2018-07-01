package com.bkpw.projektkoncowy.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "companies")
public class Company extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "nip")
    private String nip;


    @Column(name = "phone_no")
    private String phone;


    @Column(name = "fax")
    private String fax;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",
            referencedColumnName = "id",
            nullable = false)
    private Address address;

    @OneToMany(mappedBy = "company")
    private List<Department> departments;


}
