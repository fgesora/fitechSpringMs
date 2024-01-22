package com.loopdfs.cardproject.dto.card;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
@Data
@SuperBuilder
@NoArgsConstructor
public class CardResponseDTO extends CardDTO{
    private LocalDateTime createdDate;
}
