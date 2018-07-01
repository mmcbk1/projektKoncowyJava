package com.bkpw.projektkoncowy.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @Column(name = "name")
    private String name;


    @Column(name = "last_name")
    private String lastName;


    @Column(name = "email")
    //@Email(message = "Email should be valid")
    private String email;


    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;


    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    @Past
    private Date birthDate;


    @Column(name = "salary")
    private Integer salary;


    @Temporal(TemporalType.DATE)
    @Column(name = "hire_date")
    private Date hireDate;


    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;


    @Column(name = "roles")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Role> userRoles;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private Position position;




}
