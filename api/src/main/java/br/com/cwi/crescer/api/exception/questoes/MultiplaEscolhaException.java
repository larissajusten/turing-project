package br.com.cwi.crescer.api.exception.questoes;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class MultiplaEscolhaException extends RuntimeException  {
    public MultiplaEscolhaException(String message) {
        super(message);
    }
}

