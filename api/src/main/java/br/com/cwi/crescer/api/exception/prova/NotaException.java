package br.com.cwi.crescer.api.exception.prova;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class NotaException extends RuntimeException {
    public NotaException(String message) {
        super(message);
    }
}
