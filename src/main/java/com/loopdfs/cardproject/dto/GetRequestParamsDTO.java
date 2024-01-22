package com.loopdfs.cardproject.dto;

import com.loopdfs.cardproject.enums.SortCriteria;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.swing.*;

@Data
@SuperBuilder
@NoArgsConstructor
public class GetRequestParamsDTO extends RequestDTO{
    private int offset = 0;
    private int limit = 20;
    private SortCriteria sortCriteria = SortCriteria.CREATED_DATE;
    private SortOrder sortOrder = SortOrder.DESCENDING;
}
