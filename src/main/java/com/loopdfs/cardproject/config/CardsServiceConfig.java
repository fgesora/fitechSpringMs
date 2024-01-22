package com.loopdfs.cardproject.config;

import com.loopdfs.cardproject.commons.MongoConfig;
import com.loopdfs.cardproject.commons.config.DozierConfig;
import com.loopdfs.cardproject.enums.MongoTemplates;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;
@Configuration
public class CardsServiceConfig extends BaseServiceConfig {
    private final CardsRepositoryConfig cardRepositoryConfig;
    private final MongoTemplate cardMongoTemplate;

    @Autowired
    public CardsServiceConfig(MongoConfig mongoConfig, DozierConfig dozierConfig,
                              CardsRepositoryConfig cardsRepositoryConfig, ApplicationContext applicationContext) {
        super(mongoConfig, dozierConfig);
        this.cardRepositoryConfig = cardsRepositoryConfig;
        cardMongoTemplate = applicationContext.getBean(MongoTemplates.CARD_MONGO_TEMPLATE.getMongoTemplate(), MongoTemplate.class);
    }
    public void Configure(List<Class<?>> mapperEntities) {
        dozierConfig.addIgnoreNullMapperConfig(mapperEntities);
    }

    public DozerBeanMapper getModelMapper() {
        return modelMapper;
    }
    @Bean
    CardsServiceConfig getCardServiceConfig() {
        return this;
    }
    public MongoConfig getMongoConfig() {
        return mongoConfig;
    }
    public CardsRepositoryConfig getCardRepositoryConfig() {
        return cardRepositoryConfig;
    }
    public MongoTemplate getCardMongoTemplates() {
        return cardMongoTemplate;
    }

    public CardsRepositoryConfig getCardsRepositoryConfig() {
        return cardRepositoryConfig;
    }

}
