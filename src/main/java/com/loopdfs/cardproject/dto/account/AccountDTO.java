package com.loopdfs.cardproject.dto.account;

import com.loopdfs.cardproject.dto.RequestDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class AccountDTO extends RequestDTO {
    private String id;
    private String iban;
    private String bicSwift;
    private Long customerId;
}
