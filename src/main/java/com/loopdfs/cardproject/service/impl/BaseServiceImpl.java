package com.loopdfs.cardproject.service.impl;

import com.loopdfs.cardproject.commons.MongoConfig;
import com.loopdfs.cardproject.config.BaseServiceConfig;
import com.loopdfs.cardproject.dto.GetRequestParamsDTO;
import com.loopdfs.cardproject.enums.SortCriteria;
import org.dozer.DozerBeanMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public class BaseServiceImpl {
    final DozerBeanMapper modelMapper;
    final MongoConfig mongoConfig;
    public BaseServiceImpl(BaseServiceConfig baseServiceConfig, List<Class<?>> mapperEntities){
        baseServiceConfig.Configure(mapperEntities);
        this.modelMapper = baseServiceConfig.getModelMapper();
        this.mongoConfig = baseServiceConfig.getMongoConfig();
    }
    Pageable getPageable(GetRequestParamsDTO getRequestParams) {
        Sort sort = SortCriteria.getSort(getRequestParams.getSortCriteria().toString(), getRequestParams.getSortOrder().toString());
        return  PageRequest.of(getRequestParams.getOffset(), getRequestParams.getLimit(), sort);
    }

}
