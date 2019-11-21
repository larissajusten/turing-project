package br.com.cwi.crescer.api.exception.usuario;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class UsuariojaTemProvaEmVigorException extends RuntimeException {
    public UsuariojaTemProvaEmVigorException(String message) {
        super(message);

    }
}
