package br.com.cwi.crescer.api.validator;

import br.com.cwi.crescer.api.exception.questoes.QuestaoNaoEncontradaException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class QuestaoValidatorTest {

    @InjectMocks
    QuestaoValidator questaoValidator;

    @Test
    public void devePassarPelaValidacaoSemLancarException() {
        int quantDaListaQueAtendeRequisitos = 3;
        int quantQuestoesPedidas = 2;

        questaoValidator.validar(quantDaListaQueAtendeRequisitos, quantQuestoesPedidas);
    }

    @Test(expected = QuestaoNaoEncontradaException.class)
    public void deveLancarExceptionQuandoQuantDaListaQueAtendeRequisitosForZero() {
        int quantDaListaQueAtendeRequisitos = 0;
        int quantQuestoesPedidas = 2;

        questaoValidator.validar(quantDaListaQueAtendeRequisitos, quantQuestoesPedidas);
    }

    @Test(expected = QuestaoNaoEncontradaException.class)
    public void deveLancarExceptionQuandoQuantDaListaQueAtendeRequisitosForMenorQueQuantQuestoesPedidas() {
        int quantDaListaQueAtendeRequisitos = 1;
        int quantQuestoesPedidas = 2;

        questaoValidator.validar(quantDaListaQueAtendeRequisitos, quantQuestoesPedidas);
    }
}