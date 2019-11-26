package com.mexpedition.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ImpossibleAjouterExpedtionException extends RuntimeException {
    public ImpossibleAjouterExpedtionException(String s) {
        super(s);
    }
}
