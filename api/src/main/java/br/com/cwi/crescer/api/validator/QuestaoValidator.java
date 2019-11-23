package br.com.cwi.crescer.api.validator;

import br.com.cwi.crescer.api.exception.questoes.QuestaoNaoEncontradaException;
import org.springframework.stereotype.Component;

@Component
public class QuestaoValidator {

    public void validar(int quantDaListaQueAtendeRequisitos, int quantQuestoesPedidas) {

        if (quantDaListaQueAtendeRequisitos == 0) {
            throw new QuestaoNaoEncontradaException("Nenhuma questão com essa especificidade " +
                    "e nivel de dificuldade foi encontrada.");
        } else if (quantDaListaQueAtendeRequisitos < quantQuestoesPedidas) {
            throw new QuestaoNaoEncontradaException("Número de questões solicitado maior do que " +
                    "disponíveis com essa especificidade e nivel de dificuldade.");
        }
    }

}
