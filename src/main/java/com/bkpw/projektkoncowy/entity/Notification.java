package com.bkpw.projektkoncowy.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notifications")
public class Notification extends BaseEntity {

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",
            referencedColumnName = "id",
            nullable = false)
    private User user;

    @NotNull
    @Column(name = "notification_type", nullable = false)
    private String type;

    @NotNull
    @Column(name = "read_at", nullable = false)
    private LocalDateTime readAt;
}
