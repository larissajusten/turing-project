package br.com.cwi.crescer.api.exception.questoes;

public class QuestaoNaoEncontradaException extends RuntimeException {
    public QuestaoNaoEncontradaException(String message) {
        super(message);
    }
}
