package com.bkpw.projektkoncowy.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@Entity
@Table(name = "departments")
public class Department extends BaseEntity {

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "short_name", nullable = false)
    private String shortName;

  /*  @OneToMany(
            mappedBy = "department")
    private List<User> users;
*/
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",
            referencedColumnName = "id",
            nullable = false)
    private Address addresses;
}
