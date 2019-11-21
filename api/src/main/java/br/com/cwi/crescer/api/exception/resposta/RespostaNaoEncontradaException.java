package br.com.cwi.crescer.api.exception.resposta;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RespostaNaoEncontradaException extends RuntimeException {
    public RespostaNaoEncontradaException(String message) {
        super(message);

    }
}
