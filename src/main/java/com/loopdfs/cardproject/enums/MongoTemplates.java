package com.loopdfs.cardproject.enums;

public enum MongoTemplates {
    CARD_MONGO_TEMPLATE("cardMongoTemplate"),
    ACCOUNTS_MONGO_TEMPLATE("accountMongoTemplate"),
    DOCUMENT_MONGO_TEMPLATE("documentMongoTemplate");
    private final String mongoTemplate;
    MongoTemplates(String mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    public String getMongoTemplate() {
        return mongoTemplate;
    }
}
