package com.stocks.stocksapi.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class BaseModel {

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date created_on;

    @UpdateTimestamp
    private Date modified_on;

}
