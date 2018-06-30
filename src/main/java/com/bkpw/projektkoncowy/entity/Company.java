package com.bkpw.projektkoncowy.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "companies")
public class Company extends BaseEntity{

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "nip", nullable = false,unique = true)
    private String nip;

    @NotNull
    @Column(name = "phone_no", nullable = false)
    private String phone;

    @NotNull
    @Column(name = "fax", nullable = false)
    private String fax;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",
            referencedColumnName = "id",
            nullable = false)
    private Address address;

    @OneToMany(mappedBy = "company")
    private List<Department> departments;


}
