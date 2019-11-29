package br.com.cwi.crescer.api.validator;

import br.com.cwi.crescer.api.exception.prova.NotaException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NotaValidatorTest {

    @InjectMocks
    NotaValidator notaValidator;

    @Test(expected = NotaException.class)
    public void deveDispararUmaValidacaoDeAplicacaoExceptionQuandoNotaForInferiorANotaMinimaOuSuperiorANotaMaxima() {

        notaValidator.validar(11);
    }

    @Test
    public void devePassarPeloMetodoSemLancarExceptionSeOValorDaNotaEstiverEntre10e0() {
        notaValidator.validar(5);

    }

}