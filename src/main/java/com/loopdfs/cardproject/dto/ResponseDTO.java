package com.loopdfs.cardproject.dto;

public class ResponseDTO {
    private Object data;
    private Integer totalPages;
    private Long totalElements;

    public ResponseDTO() {
    }

    public ResponseDTO(Object data) {
        this.data = data;
    }

    public ResponseDTO(Object data, Long totalElements) {
        this.data = data;
        this.totalElements = totalElements;
    }

    public ResponseDTO(Object data, Long totalElements, int limit) {
        this.data = data;
        this.totalElements = totalElements;
        this.totalPages = computeTotalNumberOfPages(limit);
    }

    private int computeTotalNumberOfPages(int limit) {
        int numberOfPages = Math.toIntExact(Math.abs(totalElements / limit));
        int leftOverRecords = Math.toIntExact(Math.abs(totalElements % limit));
        return (0 == leftOverRecords) ? numberOfPages : numberOfPages + 1;
    }
}
