package br.com.cwi.crescer.api.validator;

import br.com.cwi.crescer.api.exception.questoes.QuestaoNaoEncontradaException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class PageDeQuestoesValidatorTest {

    @InjectMocks
    PageDeQuestoesValidator pageDeQuestoesValidator;

    @Test(expected = QuestaoNaoEncontradaException.class)
    public void deveLancarQuestaoNaoEncontradaExceptionQuandoOValorForZero() {
        pageDeQuestoesValidator.validar(0);
    }

    @Test
    public void devePassarPeloValidatorSemLancarExceptionQuandoOValorForMaiorQueZero() {
        pageDeQuestoesValidator.validar(1);
    }

}