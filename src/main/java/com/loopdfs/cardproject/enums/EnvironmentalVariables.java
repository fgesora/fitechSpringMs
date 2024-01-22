package com.loopdfs.cardproject.enums;

public enum EnvironmentalVariables {
    MONGO_DB_CONNECTION_STRING("MONGO_DB_CONNECTION_STRING", true),
    RUN_ENVIRONMENT("RUN_ENVIRONMENT", true);

    private final String environmentalVariable;
    private final boolean isRequired;

    EnvironmentalVariables(String environmentalVariable, boolean isRequired) {
        this.environmentalVariable = environmentalVariable;
        this.isRequired = isRequired;
    }

    @Override
    public String toString() {
        return this.environmentalVariable;
    }

    public boolean isRequired() {
        return this.isRequired;
    }
}
