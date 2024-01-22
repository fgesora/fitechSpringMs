package com.loopdfs.cardproject.config.MongoConfig;

import com.loopdfs.cardproject.commons.MongoConfig;
import com.loopdfs.cardproject.dao.BaseEntity;
import com.loopdfs.cardproject.enums.CardDBSchemes;
import com.loopdfs.cardproject.repository.DBSchemes;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

public class DocumentDBConfiguration {
    private final MongoConfig mongoConfig;
    public DocumentDBConfiguration(MongoConfig mongoConfig) {
        mongoConfig.configureMongoTemplate(CardDBSchemes.DOCUMENT_DB_SCHEME.getScheme(),
                "com.loopdfs.cardproject.repository.document", BaseEntity.class);
        this.mongoConfig = mongoConfig;
    }

    @Bean
    public MongoTemplate documentMongoTemplate() {
        return mongoConfig.getNewMongoTemplate();
    }
}
