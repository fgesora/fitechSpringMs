package com.loopdfs.cardproject.service.impl;

import com.loopdfs.cardproject.config.CardsServiceConfig;
import com.loopdfs.cardproject.dao.CardDAO;
import com.loopdfs.cardproject.dto.ResponseDTO;
import com.loopdfs.cardproject.dto.card.CardDTO;
import com.loopdfs.cardproject.dto.card.CardResponseDTO;
import com.loopdfs.cardproject.dto.card.SaveCardDTO;
import com.loopdfs.cardproject.dto.card.UpdateCardDTO;
import com.loopdfs.cardproject.exceptions.AccountDataNotFoundException;
import com.loopdfs.cardproject.service.CardService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Slf4j
@Service
public class CardServiceImpl extends BaseCardServiceImpl implements CardService {

    @Autowired CardServiceImpl(CardsServiceConfig cardsServiceConfig) {
        super(cardsServiceConfig, Arrays.asList(CardDAO.class, CardDTO.class));
    }

    @Override
    public ResponseDTO saveCard(SaveCardDTO saveCardDTO) {
        CardDAO cardDAO = modelMapper.map(saveCardDTO, CardDAO.class);
        CardDAO persistCardResponse = cardRepository.save(cardDAO);
        return new ResponseDTO(modelMapper.map(cardRepository.save(persistCardResponse), CardResponseDTO.class));
    }

    @Override
    public ResponseDTO updateCard(UpdateCardDTO updateCardDTO) {
        return updateACard(modelMapper.map(updateCardDTO, CardDAO.class));
    }

    @Override
    public void deleteCardById(String id) {
        ObjectId recordId = new ObjectId(id);
        Optional<CardDAO> optionalCardDAO = cardRepository.findById(recordId);
        if(optionalCardDAO.isPresent()){
            cardRepository.delete(optionalCardDAO.get());
        } else {
            throw new AccountDataNotFoundException("Card not found " + id);
        }
    }

    private ResponseDTO updateACard(CardDAO cardToUpdate){
        Optional<CardDAO> optionalCardDAO = cardRepository.findById(cardToUpdate.getId());
        if (optionalCardDAO.isPresent()){
            CardDAO existingCard = optionalCardDAO.get();
            modelMapper.map(cardToUpdate, existingCard);
            return new ResponseDTO(modelMapper.map(cardRepository.save(existingCard), CardResponseDTO.class));
        } else {
            throw new AccountDataNotFoundException("Card not found " + cardToUpdate.getId());
        }
    }

    public ResponseDTO getCardsByAccountId(Long userAccount) {
        CardDAO cardDAO = getCardById(userAccount);
        return new ResponseDTO(cardDAO);
    }

    private CardDAO getCardById(Long userAccount) {
        Optional<CardDAO> optionalCardDAO = cardRepository.findAll().stream().filter(card -> card.getAccountId().equals(userAccount)).findFirst();
        if (optionalCardDAO.isPresent()){
            return optionalCardDAO.get();
        } else {
            throw new AccountDataNotFoundException("Card not found " + userAccount);
        }
    }
}
