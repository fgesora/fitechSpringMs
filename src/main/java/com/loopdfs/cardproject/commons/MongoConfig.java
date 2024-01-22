package com.loopdfs.cardproject.commons;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.mongodb.core.index.IndexResolver;
import org.springframework.data.mongodb.core.index.MongoPersistentEntityIndexResolver;

import java.util.List;

import static com.loopdfs.cardproject.commons.config.ClassLoaderUtil.getAllClassesInPackage;

public class MongoConfig {
    private final MongoClient mongoClient = getNewMongoClient();

    private MongoTemplate mongoTemplate;

    private List<Class<?>> dataAccessObjectClasses;

    public void configureMongoTemplate(String databaseName, String daoPackageName, Class entityBaseClass) {
        this.mongoTemplate = new MongoTemplate(getNewMongoClient(), databaseName);
        this.dataAccessObjectClasses = getAllClassesInPackage(daoPackageName, entityBaseClass);
    }

    public MongoConfig() {
        this.mongoTemplate = null;
        this.dataAccessObjectClasses = null;
    }

    private MongoClient getNewMongoClient() {
        Configurator configs = new Configurator();
        ConnectionString connectionString = new ConnectionString(configs.getMongoDbConfigSettings().getMongoConnnectionString());
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).build();
        return MongoClients.create(mongoClientSettings);
    }

    public MongoClient getMongoClient() {
        return this.mongoClient;
    }

    public MongoTemplate getNewMongoTemplate() {
        return this.mongoTemplate;
    }

//    public void indexMongoDB() {
//        dataAccessObjectClasses.forEach(dataAccessObjectClass -> {
//            IndexOperations indexOps = mongoTemplate.indexOps(dataAccessObjectClass);
//            IndexResolver resolver = new MongoPersistentEntityIndexResolver(mongoTemplate.getConverter().getMappingContext());
//            resolver.resolveIndexFor(dataAccessObjectClass).forEach(indexOps::ensureIndex);
//        });
//    }
}
