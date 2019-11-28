package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RetornaErrosEAcertosMultiplaEscolhaServiceTest {

    @Mock
    RetornaErrosEAcertosPorNivelMultiplaEscolhaService retornaErrosEAcertosPorNivelMultiplaEscolhaService;

    @InjectMocks
    RetornaErrosEAcertosMultiplaEscolhaService retornaErrosEAcertosMultiplaEscolhaService;

    @Test
    public void deveRetornarNumeroDeErrosEAcertos() {

        List<Integer> errosEAcertos = new ArrayList<>();
        when(retornaErrosEAcertosPorNivelMultiplaEscolhaService.retornar(any(), any())).thenReturn(errosEAcertos);

        List<Integer> resultado = retornaErrosEAcertosMultiplaEscolhaService.retornar(Especificidade.JAVASCRIPT);

        Assert.assertEquals(errosEAcertos, resultado);
    }
}
