package br.com.cwi.crescer.api.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ValidacaoDeAplicacaoException extends RuntimeException  {
    public ValidacaoDeAplicacaoException(String message) {
        super(message);
    }
}

