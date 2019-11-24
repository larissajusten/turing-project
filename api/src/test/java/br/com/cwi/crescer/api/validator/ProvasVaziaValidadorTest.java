package br.com.cwi.crescer.api.validator;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.exception.prova.ProvaNaoEncontradaException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ProvasVaziaValidadorTest {

    @InjectMocks
    ProvasVaziaValidador provasVaziaValidador;

    @Test(expected = ProvaNaoEncontradaException.class)
    public void deveLancarProvaNaoEncontradaExceptionQuandoAListaEstiverVazia() {

    List<Prova> provas = new ArrayList<>();

        provasVaziaValidador.validar(provas);

    }

    @Test
    public void devePassarPeloValidatorSemLancarExceptionQuandoAListaNaoEstiverVazia() {

        List<Prova> provas = new ArrayList<>();
        provas.add(new Prova());

        provasVaziaValidador.validar(provas);

    }


}