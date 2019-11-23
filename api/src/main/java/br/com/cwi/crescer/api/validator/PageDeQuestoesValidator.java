package br.com.cwi.crescer.api.validator;

import br.com.cwi.crescer.api.exception.questoes.QuestaoNaoEncontradaException;
import org.springframework.stereotype.Component;

@Component
public class PageDeQuestoesValidator {

    public void validar(int numeroTotalDeElementos){
        if (numeroTotalDeElementos == 0){
            throw new QuestaoNaoEncontradaException("Não foram cadastradas questões " +
                    "dessa especificidade e nível");
        }
    }
}
