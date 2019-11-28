package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.controller.responses.LinguagensResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class RetornaLinguagensDoUsuarioServiceTest {
    @Mock
    AcrescentaNaListaLinguagensDoUsuarioService acrescentaNaListaLinguagensDoUsuarioService;
    @InjectMocks
    RetornaLinguagensDoUsuarioService retornaLinguagensDoUsuarioService;


    @Test
    public void deveRetornarVazioQuandoNaoHaLinguagens() {
        List<LinguagensResponse> linguagensResponses = new ArrayList<>();

        List<LinguagensResponse> resultado = retornaLinguagensDoUsuarioService.retornar();
        Assert.assertEquals(linguagensResponses, resultado);
    }


}