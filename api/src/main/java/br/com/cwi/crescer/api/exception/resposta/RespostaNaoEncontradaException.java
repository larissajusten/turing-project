package br.com.cwi.crescer.api.exception.resposta;

import br.com.cwi.crescer.api.exception.NaoEncontradoException;

public class RespostaNaoEncontradaException extends NaoEncontradoException {
    public RespostaNaoEncontradaException(String message) {
        super(message);

    }
}
