package com.uber.authService.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass  // means that don't create this model as a table made the child of this
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;


    @Column(nullable = false)
    @CreatedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    protected Date createdAt;

    @Column(nullable = false)
    @LastModifiedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    protected Date updatedAt;


}