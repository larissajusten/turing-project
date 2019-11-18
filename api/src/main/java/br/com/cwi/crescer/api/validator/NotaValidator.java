package br.com.cwi.crescer.api.validator;

import br.com.cwi.crescer.api.exception.ValidacaoDeAplicacaoException;
import org.springframework.stereotype.Component;

@Component
public class NotaValidator {

    private static final int NOTA_MINIMA_POSSIVEL = 0;
    private static final int NOTA_MAXIMA_POSSIVEL = 10;

    public void verificarSeNotaEMaiorQue0EMenorQueDez(double nota){

        if(nota < NOTA_MINIMA_POSSIVEL || nota > NOTA_MAXIMA_POSSIVEL){
            throw new ValidacaoDeAplicacaoException("Nota deve estar entre 0 e 10");
        }
    }
}

