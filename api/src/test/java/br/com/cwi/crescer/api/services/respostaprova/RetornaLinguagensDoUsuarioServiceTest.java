package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.controller.responses.LinguagensResponse;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

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