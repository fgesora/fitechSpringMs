package com.loopdfs.cardproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.PRECONDITION_FAILED, reason = "Account data not found")
public class AccountDataNotFoundException extends RuntimeException{
    public AccountDataNotFoundException(String message){
        super(message);
    }
}
