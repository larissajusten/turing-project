package br.com.cwi.crescer.api.exception.prova;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ACCEPTED)
public class CorrecaoNaoCompletadaException extends RuntimeException {
    public CorrecaoNaoCompletadaException(String message) {
        super(message);
    }
}
