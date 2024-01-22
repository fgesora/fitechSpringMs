package com.loopdfs.cardproject.service;

import com.loopdfs.cardproject.dto.ResponseDTO;
import com.loopdfs.cardproject.dto.card.SaveCardDTO;
import com.loopdfs.cardproject.dto.card.UpdateCardDTO;

public interface CardService {
    ResponseDTO saveCard(SaveCardDTO saveCardDTO);
    ResponseDTO getCardsByAccountId(Long userAccount);
    ResponseDTO updateCard(UpdateCardDTO updateCardDTO);
    void deleteCardById(String id);
}
