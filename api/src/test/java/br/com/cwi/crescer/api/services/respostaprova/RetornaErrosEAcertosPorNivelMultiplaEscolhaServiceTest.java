package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.resposta.RespostasMultiplaEscolhaProva;
import br.com.cwi.crescer.api.services.provaquestao.CalcularNumeroDeAcertosMultiplaEscolhaService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class RetornaErrosEAcertosPorNivelMultiplaEscolhaServiceTest {

    @InjectMocks
    RetornaErrosEAcertosPorNivelMultiplaEscolhaService retornaErrosEAcertosPorNivelMultiplaEscolhaService;

    @Mock
    CalcularNumeroDeAcertosMultiplaEscolhaService calcularNumeroDeAcertosMultiplaEscolhaService;

    @Mock
    BuscarListaDeRespostasFiltradaService buscarListaDeRespostasFiltradaService;

    @Test
    public void deveRetornarUmArrayDeInteirosQueContemAQuantiaDeAcertosEErrosQuandoRetornaErrosEAcertosPorNivelMultiplaEscolhaServiceForChamado() {

        List<Integer> erradasEAcertadas = new ArrayList<>();
        erradasEAcertadas.add(0);
        erradasEAcertadas.add(0);

        List<RespostasMultiplaEscolhaProva> lista = new ArrayList<>();

        Mockito.when(buscarListaDeRespostasFiltradaService.retornar(Especificidade.JAVASCRIPT,
                NivelDeDificuldade.DIFICIL)).thenReturn(lista);

        Assert.assertEquals(erradasEAcertadas, retornaErrosEAcertosPorNivelMultiplaEscolhaService.retornar(Especificidade.JAVASCRIPT,
                NivelDeDificuldade.DIFICIL));


    }
}