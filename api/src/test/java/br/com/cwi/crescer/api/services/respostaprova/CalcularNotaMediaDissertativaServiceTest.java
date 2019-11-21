package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
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
public class CalcularNotaMediaDissertativaServiceTest {

    @InjectMocks
    CalcularNotaMediaDissertativaService calcularNotaMediaDissertativaService;

    @Mock
    RespostasDissertativaRepository repository;

    @Test
    public void deveChamarRespostasDissertativaRepositoryQuandoCalcularNotaMediaDissertativaServiceForChamado(){

        Prova prova = new Prova();
        List<RespostasDissertativaProva> listaRespostas = new ArrayList<>();
        RespostasDissertativaProva respostasDissertativaProva = new RespostasDissertativaProva();
        listaRespostas.add(respostasDissertativaProva);
        respostasDissertativaProva.setNota(5);

        Mockito.when(repository.findAllByProvaIdEquals(prova.getId())).thenReturn(listaRespostas);

        calcularNotaMediaDissertativaService.calcular(prova.getId());

        Mockito.verify(repository).findAllByProvaIdEquals(prova.getId());
    }

    @Test
    public void deveRetornarUmDoubleQuandoCalcularNotaMediaDissertativaServiceForChamado(){

        Prova prova = new Prova();
        List<RespostasDissertativaProva> listaRespostas = new ArrayList<>();
        RespostasDissertativaProva respostasDissertativaProva = new RespostasDissertativaProva();
        listaRespostas.add(respostasDissertativaProva);
        respostasDissertativaProva.setNota(5);

        Mockito.when(repository.findAllByProvaIdEquals(prova.getId())).thenReturn(listaRespostas);

        Assert.assertEquals(5, calcularNotaMediaDissertativaService.calcular(prova.getId()), 0);
    }
}