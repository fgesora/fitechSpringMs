package com.loopdfs.cardproject.commons;

import com.loopdfs.cardproject.commons.config.EnvironmentalVariableConfig;
import com.loopdfs.cardproject.enums.EnvironmentalVariables;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;
@Configuration
public class Configurator {
    private final EnvironmentalVariableConfig environmentalVariableConfig = new EnvironmentalVariableConfig();
    private static DatabaseConfigModel databaseConfigModel;
    public DatabaseConfigModel getMongoDbConfigSettings() {
        if (Objects.isNull(databaseConfigModel)) {
            databaseConfigModel = new DatabaseConfigModel();
            databaseConfigModel.setMongoConnnectionString(
                    environmentalVariableConfig.getEnvVariable(EnvironmentalVariables.MONGO_DB_CONNECTION_STRING));
        }
        return databaseConfigModel;
    }
}
