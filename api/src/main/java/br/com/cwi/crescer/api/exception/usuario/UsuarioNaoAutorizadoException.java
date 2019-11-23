package br.com.cwi.crescer.api.exception.usuario;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UsuarioNaoAutorizadoException extends RuntimeException{
    public UsuarioNaoAutorizadoException(String message) {
        super(message);
    }
}
