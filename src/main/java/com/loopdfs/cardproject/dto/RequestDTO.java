package com.loopdfs.cardproject.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class RequestDTO {
    private String source;
    private String profileId;
}
