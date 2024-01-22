package com.loopdfs.cardproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.PRECONDITION_FAILED, reason = "Account data already exists")
public class AccountDataAlreadyExistsException extends RuntimeException{
    public AccountDataAlreadyExistsException(String message){
        super(message);
    }
}
