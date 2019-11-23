package br.com.cwi.crescer.api.exception.questoes;

import br.com.cwi.crescer.api.exception.NaoEncontradoException;

public class QuestaoNaoEncontradaException extends NaoEncontradoException {
    public QuestaoNaoEncontradaException(String message) {
        super(message);
    }
}
