package br.com.cwi.crescer.api.exception.prova;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProvaNaoEncontradaException extends RuntimeException {
    public ProvaNaoEncontradaException(String message) {
        super(message);
    }
}
