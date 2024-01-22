package com.loopdfs.cardproject.config.MongoConfig;

import com.loopdfs.cardproject.commons.MongoConfig;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.event.EventListener;

@Configuration
@Import({DocumentDBConfiguration.class, CardsDBConfiguration.class})
public class MongoDS {
    private final MongoConfig mongoConfig = new MongoConfig();
    @Bean
    public MongoConfig getNewMongoClient() {
        return mongoConfig;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initIndicesAfterStartup() {
        //mongoConfig.indexMongoDB();
    }
}
