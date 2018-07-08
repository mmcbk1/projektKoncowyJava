package com.bkpw.projektkoncowy.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntityDTO {


    Long id;

    @JsonIgnore
    private Date created_at;

    @JsonIgnore
    private Date updated_at;

    public BaseEntityDTO(Long id) {

    }
}
