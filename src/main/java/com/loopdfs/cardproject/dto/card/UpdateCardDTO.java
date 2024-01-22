package com.loopdfs.cardproject.dto.card;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.validation.constraints.NotEmpty;

@Data
@SuperBuilder
@NoArgsConstructor
public class UpdateCardDTO extends CardDTO{
    @NotEmpty(message = "id is required")
    private String id;
    @NotEmpty(message = "Card Alias is required")
    private String cardAlias;
    @ReadOnlyProperty
    private Long cardId;
    @ReadOnlyProperty
    private Long accountId;
    @ReadOnlyProperty
    private String cardType;
}
