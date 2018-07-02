package com.bkpw.projektkoncowy.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@Entity
@Table(name = "departments")
@NoArgsConstructor
@AllArgsConstructor
public class Department extends BaseEntity {

    @NotNull
    @Column(name = "name", nullable = false,unique = true)
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
    @JsonBackReference
    private Company company;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @MapsId
/*    @JoinColumn(name = "address_id",
            referencedColumnName = "id",
            nullable = false)*/
    private Address address;
}
