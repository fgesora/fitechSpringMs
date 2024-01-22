package com.loopdfs.cardproject.dto.account;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.validation.constraints.NotBlank;

@Data
@SuperBuilder
@NoArgsConstructor
public class UpdateAccountDTO extends AccountDTO{
    @NotBlank(message = "id is required")
    private String id;
    @NotBlank(message = "iban is required")
    private String iban;
    @NotBlank(message = "bicSwift: is required")
    private String bicSwift;
    @NotBlank(message = "Client id is required")
    private String clientId;
}
