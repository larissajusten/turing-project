package br.com.cwi.crescer.api.exception.prova;

import br.com.cwi.crescer.api.exception.NaoEncontradoException;

public class ProvaNaoEncontradaException extends NaoEncontradoException {
    public ProvaNaoEncontradaException(String message) {
        super(message);
    }
}
