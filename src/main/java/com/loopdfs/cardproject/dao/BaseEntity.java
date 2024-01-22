package com.loopdfs.cardproject.dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;
@Data
@SuperBuilder
@NoArgsConstructor
public class BaseEntity {
    @Id
    private ObjectId id;

    @Indexed
    @CreatedDate
    private LocalDateTime createdDate;

    @Indexed
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @Indexed
    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String lastModifiedBy;
}
