package com.loopdfs.cardproject.commons.config;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DozierConfig {
    private final DozerBeanMapper dozerBeanMapper;


    public DozierConfig() {
        this.dozerBeanMapper = getNewCustomConfiguredDozerBeanMapper();
    }

    public void addIgnoreNullMapperConfig(List<Class<?>> entityClasses) {
        dozerBeanMapper.addMapping(
                new BeanMappingBuilder() {
                    protected void configure() {
                        entityClasses.forEach(entityClass -> {
                            mapping(entityClass, entityClass, TypeMappingOptions.mapNull(false));
                        });
                    }
                });
    }

    private DozerBeanMapper getNewCustomConfiguredDozerBeanMapper() {
        List<String> mappingFiles = new ArrayList();
        mappingFiles.add("dozerJdk8Converters.xml");
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.setMappingFiles(mappingFiles);
        return dozerBeanMapper;
    }

    @Bean
    public DozerBeanMapper getDozerBeanMapper() {
        return dozerBeanMapper;
    }
}
