package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.resposta.RespostasTecnicaProva;
import br.com.cwi.crescer.api.repository.resposta.RespostasTecnicaRepository;
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
public class CalcularNotaMediaTecnicaServiceTest {

    @InjectMocks
    CalcularNotaMediaTecnicaService calcularNotaMediaTecnicaService;

    @Mock
    RespostasTecnicaRepository repository;


    @Test
    public void deveChamarRespostasTecnicaRepositoryQuandoCalcularNotaMediaTecnicaServiceForChamado() {

        Prova prova = new Prova();
        List<RespostasTecnicaProva> listaRespostas = new ArrayList<>();
        RespostasTecnicaProva respostasTecnicaProva = new RespostasTecnicaProva();
        listaRespostas.add(respostasTecnicaProva);
        respostasTecnicaProva.setNota(8);

        Mockito.when(repository.findAllByProvaIdEquals(prova.getId())).thenReturn(listaRespostas);

        calcularNotaMediaTecnicaService.calcular(prova.getId());

        Mockito.verify(repository).findAllByProvaIdEquals(prova.getId());

    }

    @Test
    public void deveRetornarUmDoubleComANotaQuandoCalcularNotaMediaTecnicaServiceForChamado() {

        Prova prova = new Prova();
        List<RespostasTecnicaProva> listaRespostas = new ArrayList<>();
        RespostasTecnicaProva respostasTecnicaProva = new RespostasTecnicaProva();
        RespostasTecnicaProva respostasTecnicaProva2 = new RespostasTecnicaProva();

        listaRespostas.add(respostasTecnicaProva);
        listaRespostas.add(respostasTecnicaProva2);
        respostasTecnicaProva2.setNota(2);
        respostasTecnicaProva.setNota(8);

        Mockito.when(repository.findAllByProvaIdEquals(prova.getId())).thenReturn(listaRespostas);

        Assert.assertEquals(5, calcularNotaMediaTecnicaService.calcular(prova.getId()), 0);


    }
}