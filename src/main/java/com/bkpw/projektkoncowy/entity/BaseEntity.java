package com.bkpw.projektkoncowy.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;


@Data
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties(value = {"created_at", "updated_at"},allowGetters = true)
@EntityListeners(AuditingEntityListener.class)
public  abstract class BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Temporal(TIMESTAMP)
    @Column(updatable = false)
    private Date created_at;

    @LastModifiedDate
    @Temporal(TIMESTAMP)
    private Date updated_at;
}
