package com.loopdfs.cardproject.commons.config;

import com.loopdfs.cardproject.enums.EnvironmentalVariables;

import java.util.Objects;
import java.util.Properties;

public class EnvironmentalVariableConfig {

        private Properties localProperty;

        public String getEnvVariable(EnvironmentalVariables env) {
            String variable = env.toString();
            String value = isLocalEnv() ? getProperty(variable) : System.getenv(variable);

            if (env.isRequired() && (value == null || value.length() == 0)) {
                throw new RuntimeException("Environment variable " + variable + " is required and not present.");
            }

            return value;
        }

        private static boolean isLocalEnv() {
            return Objects.isNull(System.getenv(EnvironmentalVariables.RUN_ENVIRONMENT.toString()));
        }

        private String getProperty(String property) {
            if (Objects.isNull(localProperty)) {
                localProperty = PropertyFileUtils
                        .getConfigProperties("application-local.properties", this.getClass().getClassLoader());
            }
            return localProperty.getProperty(property);
        }
}
