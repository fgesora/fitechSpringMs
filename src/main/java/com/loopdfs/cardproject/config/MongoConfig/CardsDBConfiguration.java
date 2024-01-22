package com.loopdfs.cardproject.config.MongoConfig;

import com.loopdfs.cardproject.commons.MongoConfig;
import com.loopdfs.cardproject.dao.BaseEntity;
import com.loopdfs.cardproject.enums.CardDBSchemes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(
        basePackages = "com.loopdfs.cardproject.repository.card",
        mongoTemplateRef = "cardMongoTemplate"
)
public class CardsDBConfiguration {
    private final MongoConfig mongoConfig;

    public CardsDBConfiguration(MongoConfig mongoConfig) {
        mongoConfig.configureMongoTemplate(CardDBSchemes.CARD_DB_SCHEME.getScheme(),
                "com.loopdfs.cardproject.dao.card", BaseEntity.class);
        this.mongoConfig = mongoConfig;
    }

    @Bean
    @Primary
    public MongoTemplate cardMongoTemplate() {
        return mongoConfig.getNewMongoTemplate();
    }
}
