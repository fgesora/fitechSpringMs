package com.loopdfs.cardproject.enums;

import org.springframework.data.domain.Sort;

public enum SortCriteria {
    CREATED_DATE("createdDate"),
    PUBLISH_ORDER("publishOrder"),
    MODIFIED_DATE("lastModifiedDate");

    private final String sortCriteriaValue;

    SortCriteria(String sortCriteriaValue) {
        this.sortCriteriaValue = sortCriteriaValue;
    }

    public static Sort getSort(String sortCriteria, String order) {
        return "desc".equalsIgnoreCase(order) ? Sort.by(SortCriteria.getSortCriteriaValue(sortCriteria))
                .descending() : Sort.by(SortCriteria.getSortCriteriaValue(sortCriteria))
                .ascending();
    }

    public static String getSortCriteriaValue(String sortCriteria) {
        return sortCriteria != null ? SortCriteria.valueOf(sortCriteria).getSortCriteriaValue() :
                SortCriteria.CREATED_DATE.getSortCriteriaValue();
    }

    public String getSortCriteriaValue() {
        return sortCriteriaValue;
    }
}
