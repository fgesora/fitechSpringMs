package com.loopdfs.cardproject.dto.card;

import javax.validation.constraints.NotBlank;

public class SaveCardDTO extends  CardDTO{
    @NotBlank(message = "id is required")
    private Long cardId;
    @NotBlank(message = "cardAlias is required")
    private String cardAlias;
    @NotBlank(message = "accountId is required")
    private Long accountId;
    @NotBlank(message = "cardType is required")
    private String cardType;
}
