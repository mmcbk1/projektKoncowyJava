package com.bkpw.projektkoncowy.entity;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;



@Data
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public  abstract class BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date created_at;

    @Temporal(TemporalType.DATE)
    private Date updated_at;
}
