package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.services.questaodissertativa.BuscarNumeroDeVezesQuestoesDissertativaPorEspecificidadeService;
import br.com.cwi.crescer.api.services.questaomultiplaescolha.BuscarNumeroDeVezesQuestoesMultiplaPorEspecificidadeService;
import br.com.cwi.crescer.api.services.questaotecnica.BuscarNumeroDeVezesQuestoesTecnicasPorEspecificidadeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RetornaTotalPorLinguagemServiceTest {
    @Mock
    BuscarNumeroDeVezesQuestoesDissertativaPorEspecificidadeService buscarNumeroDeVezesQuestoesDissertativaPorEspecificidadeService;

    @Mock
    BuscarNumeroDeVezesQuestoesMultiplaPorEspecificidadeService buscarNumeroDeVezesQuestoesMultiplaPorEspecificidadeService;

    @Mock
    BuscarNumeroDeVezesQuestoesTecnicasPorEspecificidadeService buscarNumeroDeVezesQuestoesTecnicasPorEspecificidadeService;

    @InjectMocks
    RetornaTotalPorLinguagemService retornaTotalPorLinguagemService;


    @Test
    public void deveRetornarSomaDoNumeroDeVezesQueTodasQuestoesForemUsadas() throws Exception {
        when(buscarNumeroDeVezesQuestoesDissertativaPorEspecificidadeService.buscar(any())).thenReturn(10);
        when(buscarNumeroDeVezesQuestoesMultiplaPorEspecificidadeService.buscar(any())).thenReturn(10);
        when(buscarNumeroDeVezesQuestoesTecnicasPorEspecificidadeService.buscar(any())).thenReturn(10);

        int resultado = retornaTotalPorLinguagemService.retornar(Especificidade.JAVASCRIPT);
        Assert.assertEquals(30, resultado);
    }
}