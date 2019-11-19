package br.com.cwi.crescer.api.validator;

import br.com.cwi.crescer.api.exception.ValidacaoDeAplicacaoException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NotaValidatorTest {

    @InjectMocks
    NotaValidator notaValidator;

    @Test(expected = ValidacaoDeAplicacaoException.class)
    public void deveDispararUmaValidacaoDeAplicacaoExceptionQuandoNotaForInferiorANotaMinimaOuSuperiorANotaMaxima() {

        notaValidator.verificarSeNotaEMaiorQue0EMenorQueDez(11);

    }

}