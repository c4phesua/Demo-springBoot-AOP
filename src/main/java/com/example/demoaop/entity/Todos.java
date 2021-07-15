package com.example.demoaop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "todos")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Todos extends BaseEntity{
    @Getter
    @Setter
    @Column(name = "user_id")
    private Integer userId;

    @Getter
    @Setter
    @Column(name = "created_at")
    private Instant createAt;

    @Getter
    @Setter
    @Column(name = "updated_at")
    private Instant updateAt;

    @Getter
    @Setter
    @Column(name = "value")
    private String value;

    @Getter
    @Setter
    @Column(name = "status")
    private String status;
}
