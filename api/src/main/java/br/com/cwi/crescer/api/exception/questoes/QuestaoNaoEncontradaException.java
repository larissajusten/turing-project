package br.com.cwi.crescer.api.exception.questoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class QuestaoNaoEncontradaException extends RuntimeException {
    public QuestaoNaoEncontradaException(String message) {
        super(message);
    }
}
