package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RetornarNotaDaQuestaoMultiplaEscolhaServiceTest {

    @InjectMocks
    RetornarNotaDaQuestaoMultiplaEscolhaService retornarNotaDaQuestaoMultiplaEscolhaService;

    @Test
    public void deveRetornarUmInteiroDeValor10QuandoONivelDeDificuldadeForFacil() {

        Assert.assertEquals(10, retornarNotaDaQuestaoMultiplaEscolhaService
                .notaQuestaoMultiplaEscolha(NivelDeDificuldade.FACIL));

    }

    @Test
    public void deveRetornarUmInteiroDeValor20QuandoONivelDeDificuldadeForMedio() {

        Assert.assertEquals(20, retornarNotaDaQuestaoMultiplaEscolhaService
                .notaQuestaoMultiplaEscolha(NivelDeDificuldade.MEDIO));

    }

    @Test
    public void deveRetornarUmInteiroDeValor30QuandoONivelDeDificuldadeForDificil() {

        Assert.assertEquals(30, retornarNotaDaQuestaoMultiplaEscolhaService
                .notaQuestaoMultiplaEscolha(NivelDeDificuldade.DIFICIL));

    }

}