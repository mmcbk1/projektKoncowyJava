package com.bkpw.projektkoncowy.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "messages")
public class Message extends BaseEntity{

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sender_id",
            referencedColumnName = "id",
            nullable = false)
    private User sender;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receiver_id",
            referencedColumnName = "id",
            nullable = false)
    private User receiver;

    @NotNull
    @Column(name = "content_message", nullable = false)
    private String content;

}
