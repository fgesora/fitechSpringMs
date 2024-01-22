package com.loopdfs.cardproject.dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("card_collection")
@SuperBuilder
@NoArgsConstructor
public class CardDAO extends BaseEntity{
    @Indexed
    @ReadOnlyProperty
    private String cardNumber;
    private String cardAlias;
    @Indexed
    @ReadOnlyProperty
    private Long accountId;
    @ReadOnlyProperty
    private String cardType;
    private LocalDateTime lastPublishDate;
    private String lastPublishBy;
    private String lastUpdateddBy;
    private LocalDateTime lastUpdateddDate;
}
