package com.loopdfs.cardproject.dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("account_collection")
@SuperBuilder
@NoArgsConstructor
public class AccountDAO extends BaseEntity{
    @Indexed
    private String accountId;
    private String iban;
    private String bicSwift;
    @Indexed
    private Long customerId;
    private LocalDateTime lastPublishDate;
    private String lastPublishBy;
    private String lastUpdateddBy;
    private LocalDateTime lastUpdateddDate;

}
