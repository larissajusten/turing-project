package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@RunWith(MockitoJUnitRunner.class)
public class VerificarSeProvaEstaDentroDoPrazoParaIniciarServiceTest {

    @InjectMocks
    VerificarSeProvaEstaDentroDoPrazoParaIniciarService verificarSeProvaEstaDentroDoPrazoParaIniciarService;


    @Test
    public void deveRetornarTrueQuandoAProvaEstiverNoPrazoParaSerFeita() {

        Prova prova = new Prova();
        prova.setDataCriacao(LocalDateTime.now());
        prova.setTempoParaInicioProva(20);

        Assert.assertTrue(verificarSeProvaEstaDentroDoPrazoParaIniciarService.verificar(prova));

    }

    @Test
    public void deveRetornarFalseQuandoAProvaEstiverNoPrazoParaSerFeita() {

        Prova prova = new Prova();
        prova.setDataCriacao(LocalDateTime.of(LocalDate.of(1988, 10, 10), LocalTime.now()));
        prova.setTempoParaInicioProva(10);

        Assert.assertFalse(verificarSeProvaEstaDentroDoPrazoParaIniciarService.verificar(prova));

    }

    @Test
    public void deveAlterarOStatusDaProvaParaForaDoPrazoParaRealizacaoDaProvaQuandoAProvaEstiverNoPrazoParaSerFeitaEORetornoForFalse() {

        Prova prova = new Prova();
        prova.setDataCriacao(LocalDateTime.of(LocalDate.of(1988, 10, 10), LocalTime.now()));
        prova.setTempoParaInicioProva(10);

        verificarSeProvaEstaDentroDoPrazoParaIniciarService.verificar(prova);

        Assert.assertEquals(StatusProva.FORA_DO_PRAZO_PARA_REALIZAR_PROVA, prova.getStatus());


    }


}