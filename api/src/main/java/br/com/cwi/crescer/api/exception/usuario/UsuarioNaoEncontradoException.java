package br.com.cwi.crescer.api.exception.usuario;

import br.com.cwi.crescer.api.exception.NaoEncontradoException;

public class UsuarioNaoEncontradoException extends NaoEncontradoException {
    public UsuarioNaoEncontradoException(String message) {
        super(message);
    }
}
