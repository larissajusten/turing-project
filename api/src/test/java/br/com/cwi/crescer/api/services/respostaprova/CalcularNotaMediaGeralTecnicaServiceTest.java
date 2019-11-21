package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
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
public class CalcularNotaMediaGeralTecnicaServiceTest {

    @InjectMocks
    CalcularNotaMediaGeralTecnicaService calcularNotaMediaGeralTecnicaService;

    @Mock
    RespostasTecnicaRepository repository;

    @Test
    public void deveRetornarAMediaDasNotasDaQuestaoQuandoCalcularNotaMediaGeralTecnicaServiceForChamado() {

        List<RespostasTecnicaProva> listaRespostas = new ArrayList<>();
        RespostasTecnicaProva respostasTecnicaProva = new RespostasTecnicaProva();
        RespostasTecnicaProva respostasTecnicaProva2 = new RespostasTecnicaProva();

        QuestaoTecnica questaoTecnica = new QuestaoTecnica();
        listaRespostas.add(respostasTecnicaProva);
        listaRespostas.add(respostasTecnicaProva2);
        respostasTecnicaProva.setNota(5);
        respostasTecnicaProva2.setNota(7);


        Mockito.when(repository.findAllByQuestaoTecnicaIdEquals(questaoTecnica.getId()))
                .thenReturn(listaRespostas);

        Assert.assertEquals(6, calcularNotaMediaGeralTecnicaService
                .calcular(questaoTecnica.getId()), 0);
    }

    @Test
    public void deveChamarRespostasTecnicaRepositoryQuandoCalcularNotaMediaGeralTecnicaServiceForChamado() {

        List<RespostasTecnicaProva> listaRespostas = new ArrayList<>();
        RespostasTecnicaProva respostasTecnicaProva = new RespostasTecnicaProva();
        RespostasTecnicaProva respostasTecnicaProva2 = new RespostasTecnicaProva();

        QuestaoTecnica questaoTecnica = new QuestaoTecnica();
        listaRespostas.add(respostasTecnicaProva);
        listaRespostas.add(respostasTecnicaProva2);
        respostasTecnicaProva.setNota(5);
        respostasTecnicaProva2.setNota(7);


        Mockito.when(repository.findAllByQuestaoTecnicaIdEquals(questaoTecnica.getId()))
                .thenReturn(listaRespostas);

        calcularNotaMediaGeralTecnicaService
                .calcular(questaoTecnica.getId());

        Mockito.verify(repository).findAllByQuestaoTecnicaIdEquals(questaoTecnica.getId());
    }
}