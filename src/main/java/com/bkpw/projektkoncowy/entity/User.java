package com.bkpw.projektkoncowy.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "User")
public class User extends BaseEntity {

    @NotNull
    @Size(min=1, max=16)
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Email should be valid")
    private String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;


    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date", nullable = false)
    @Past
    private Date birthDate;

    @NotNull
    @Column(name = "salary", nullable = false)
    private Integer salary;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "hire_date", nullable = false)
    private Date hireDate;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;


    @Column(name = "roles", nullable = false)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Role> userRoles;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private Position position;




}
