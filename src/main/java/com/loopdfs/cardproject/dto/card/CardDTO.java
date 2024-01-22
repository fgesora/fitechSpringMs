package com.loopdfs.cardproject.dto.card;

import com.loopdfs.cardproject.dto.RequestDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class CardDTO extends RequestDTO {
    private String id;
    private Long cardId;
    private String cardAlias;
    private Long accountId;
    private String cardType;
}
