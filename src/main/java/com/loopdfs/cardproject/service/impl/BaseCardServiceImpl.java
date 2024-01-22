package com.loopdfs.cardproject.service.impl;

import com.loopdfs.cardproject.config.CardsServiceConfig;
import com.loopdfs.cardproject.dto.GetRequestParamsDTO;
import com.loopdfs.cardproject.enums.SortCriteria;
import com.loopdfs.cardproject.repository.account.AccountRepository;
import com.loopdfs.cardproject.repository.card.CardRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

public class BaseCardServiceImpl extends BaseServiceImpl{
    final MongoTemplate cardMongoTemplate;
    final AccountRepository accountRepository;
    final CardRepository cardRepository;

    public BaseCardServiceImpl(CardsServiceConfig cardsServiceConfig, List<Class<?>> mapperEntities) {
        super(cardsServiceConfig, mapperEntities);
        this.cardMongoTemplate = cardsServiceConfig.getCardMongoTemplates();
        this.accountRepository = cardsServiceConfig.getCardRepositoryConfig().getAccountRepository();
        this.cardRepository = cardsServiceConfig.getCardRepositoryConfig().getCardRepository();
    }

    Pageable getPageable(GetRequestParamsDTO getRequestParams) {
        Sort sort = SortCriteria.getSort(getRequestParams.getSortCriteria().toString(), getRequestParams.getSortOrder().toString());
        return  PageRequest.of(getRequestParams.getOffset(), getRequestParams.getLimit(), sort);
    }
}
