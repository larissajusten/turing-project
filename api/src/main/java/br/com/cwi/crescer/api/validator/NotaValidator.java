package br.com.cwi.crescer.api.validator;

import br.com.cwi.crescer.api.exception.prova.NotaException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NotaValidator {

    public void validar(double nota) {

        if (nota < 0 || nota > 10) {
            throw new NotaException("Nota deve estar entre 0 e 10");
        }
    }
}

