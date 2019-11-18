package br.com.cwi.crescer.api.validator;

import br.com.cwi.crescer.api.exception.ValidacaoDeAplicacaoException;
import org.springframework.stereotype.Component;

@Component
public class NotaValidator {

    public void verificarSeNotaEMaiorQue0EMenorQueDez(double nota){
        if(nota < 0 || nota > 10){
            throw new ValidacaoDeAplicacaoException("Nota deve estar entre 0 e 10");
        }
    }
}
