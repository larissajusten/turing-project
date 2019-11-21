package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
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
public class CalcularNotaMediaGeralDissertativaServiceTest {

    @InjectMocks
    CalcularNotaMediaGeralDissertativaService calcularNotaMediaGeralDissertativaService;

    @Mock
    RespostasDissertativaRepository repository;

    @Test
    public void deveChamarRespostasDissertativaRepositoryQuandoCalcularNotaMediaGeralDissertativaServiceForChamado() {
        List<RespostasDissertativaProva> listaRespostas = new ArrayList<>();
        RespostasDissertativaProva respostasDissertativaProva = new RespostasDissertativaProva();
        QuestaoDissertativa questaoDissertativa = new QuestaoDissertativa();
        listaRespostas.add(respostasDissertativaProva);
        respostasDissertativaProva.setNota(10);

        Mockito.when(repository.findAllByQuestaoDissertativaIdEquals(questaoDissertativa.getId()))
                .thenReturn(listaRespostas);

        calcularNotaMediaGeralDissertativaService.calcular(questaoDissertativa.getId());

        Mockito.verify(repository).findAllByQuestaoDissertativaIdEquals(questaoDissertativa.getId());
    }

    @Test
    public void deveRetornarUmDoubleQueRepresentaAMediaDasRespostasRespostasDissertativaRepositoryQuandoCalcularNotaMediaGeralDissertativaServiceForChamado() {
        List<RespostasDissertativaProva> listaRespostas = new ArrayList<>();
        RespostasDissertativaProva respostasDissertativaProva = new RespostasDissertativaProva();
        RespostasDissertativaProva respostasDissertativaProva2 = new RespostasDissertativaProva();

        QuestaoDissertativa questaoDissertativa = new QuestaoDissertativa();
        listaRespostas.add(respostasDissertativaProva);
        listaRespostas.add(respostasDissertativaProva2);
        respostasDissertativaProva2.setNota(5);
        respostasDissertativaProva.setNota(10);

        Mockito.when(repository.findAllByQuestaoDissertativaIdEquals(questaoDissertativa.getId()))
                .thenReturn(listaRespostas);

        Assert.assertEquals(7.5, calcularNotaMediaGeralDissertativaService.calcular(questaoDissertativa.getId()), 1);


    }
}