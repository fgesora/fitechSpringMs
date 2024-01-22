package com.loopdfs.cardproject.controllers;

import com.loopdfs.cardproject.dto.ResponseDTO;
import com.loopdfs.cardproject.dto.card.SaveCardDTO;
import com.loopdfs.cardproject.dto.card.UpdateCardDTO;
import com.loopdfs.cardproject.service.CardService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/card")
@Validated
public class CardController {

    private final CardService cardService;
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping
    public ResponseDTO saveCard(@Valid @RequestBody SaveCardDTO saveCardDTO){
        return cardService.saveCard(saveCardDTO);
    }

    @PutMapping
    public ResponseDTO updateCard(@Valid @RequestBody UpdateCardDTO updateCardDTO){
        ResponseDTO updateCardResponseDTO = cardService.updateCard(updateCardDTO);
        return updateCardResponseDTO;
    }

    @DeleteMapping("{id}")
    public void deleteCard(
            @PathVariable @NotEmpty(message = "cardId is required") String id){
        cardService.deleteCardById(id);
    }

    @GetMapping("{id}")
    public ResponseDTO getCardsByAccountId(
            @PathVariable @NotEmpty(message = "cardId is required") Long id){
                ResponseDTO getResponseDTO = cardService.getCardsByAccountId(id);
                return getResponseDTO;
            }
}
