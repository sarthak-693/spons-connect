package com.sponsconnect.shared;

import org.hibernate.annotations.Filter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Filter(name = "is_delete", condition = "is_delete=false")
public class BaseEntity {

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime lastModifiedDate = LocalDateTime.now();

    @Column(name ="is_delete", nullable = false)
    private boolean isDelete = false;

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}

