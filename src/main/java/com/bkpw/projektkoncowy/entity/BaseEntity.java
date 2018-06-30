package com.bkpw.projektkoncowy.entity;


import javax.persistence.*;

import java.util.Date;

@MappedSuperclass
public  abstract class BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date created_at;

    @Temporal(TemporalType.DATE)
    private Date updated_at;
}
