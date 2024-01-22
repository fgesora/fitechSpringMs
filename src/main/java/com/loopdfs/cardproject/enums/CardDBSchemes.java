package com.loopdfs.cardproject.enums;

import com.loopdfs.cardproject.repository.DBSchemes;

public enum CardDBSchemes implements DBSchemes {
    CARD_DB_SCHEME("loop_dfs"),
    DOCUMENT_DB_SCHEME("loop_dfs_document");

    private final String cardScheme;

    CardDBSchemes(String reelScheme) {
        this.cardScheme = reelScheme;
    }

    @Override
    public String getScheme() {
        return cardScheme;
    }
}
