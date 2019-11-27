package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoDissertativa;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoTecnica;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoDissertativaRepository;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoTecnicaRepository;
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
public class GerarDivisorFinalParaNotaDaProvaServiceTest {


    @InjectMocks
    GerarDivisorFinalParaNotaDaProvaService gerarDivisorFinalParaNotaDaProvaService;

    @Mock
    ProvaQuestaoDissertativaRepository provaQuestaoDissertativaRepository;

    @Mock
    ProvaQuestaoMultiplaEscolhaRepository provaQuestaoMultiplaEscolhaRepository;

    @Mock
    ProvaQuestaoTecnicaRepository provaQuestaoTecnicaRepository;

    @Test
    public void deveRetornarUmInteiroQueReferenciaOUltimoDivisorDaNotaDaProvaQuandoGerarDivisorFinalParaNotaDaProvaServiceForChamado() {

        Prova prova = new Prova();

        ProvaQuestaoTecnica questaoTecnica = new ProvaQuestaoTecnica();
        ProvaQuestaoDissertativa questaoDissertativa = new ProvaQuestaoDissertativa();
        ProvaQuestaoMultiplaEscolha questaoMultiplaEscolha = new ProvaQuestaoMultiplaEscolha();

        List<ProvaQuestaoDissertativa> dissertativas = new ArrayList<>();
        List<ProvaQuestaoMultiplaEscolha> multiplaEscolhas = new ArrayList<>();
        List<ProvaQuestaoTecnica> tecnicas = new ArrayList<>();

        dissertativas.add(questaoDissertativa);
        tecnicas.add(questaoTecnica);
        multiplaEscolhas.add(questaoMultiplaEscolha);

        Mockito.when(provaQuestaoDissertativaRepository.findAllByProvaIdEquals(prova.getId()))
                .thenReturn(dissertativas);
        Mockito.when(provaQuestaoMultiplaEscolhaRepository.findAllByProvaIdEquals(prova.getId()))
                .thenReturn(multiplaEscolhas);
        Mockito.when(provaQuestaoTecnicaRepository.findAllByProvaIdEquals(prova.getId()))
                .thenReturn(tecnicas);

        Assert.assertEquals(3, gerarDivisorFinalParaNotaDaProvaService.retornarTotalDeQuestoesDaProva(prova));



    }
}