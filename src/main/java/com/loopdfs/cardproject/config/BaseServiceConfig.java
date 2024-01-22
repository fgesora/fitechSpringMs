package com.loopdfs.cardproject.config;

import com.loopdfs.cardproject.commons.MongoConfig;
import com.loopdfs.cardproject.commons.config.DozierConfig;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BaseServiceConfig {
    final DozerBeanMapper modelMapper;
    final DozierConfig dozierConfig;
    final MongoConfig mongoConfig;

    @Autowired
    public BaseServiceConfig(MongoConfig mongoConfig, DozierConfig dozierConfig){
        this.mongoConfig = mongoConfig;
        this.dozierConfig = dozierConfig;
        this.modelMapper = dozierConfig.getDozerBeanMapper();
    }
    public void Configure(List<Class<?>> mapperEntities) {
        dozierConfig.addIgnoreNullMapperConfig(mapperEntities);
    }

    public DozerBeanMapper getModelMapper() {
        return modelMapper;
    }

    public MongoConfig getMongoConfig() {
        return mongoConfig;
    }
}
