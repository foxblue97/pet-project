package com.product.listener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.ZonedDateTime;


@MappedSuperclass
@EntityListeners(CustomerAuditListener.class)
@Getter
@Setter
public class AbstractEntityListener {
    @CreatedDate
    private ZonedDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private ZonedDateTime modifiedAt;

    @LastModifiedBy
    private String modifiedBy;



}
