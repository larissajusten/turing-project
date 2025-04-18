package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.QuestaoDissertativaComRespostaResponse;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.mapper.QuestaoComRespostaMapper;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import br.com.cwi.crescer.api.services.respostaprova.RetornarQuestaoDissertativaComRespostaResponseService;
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
public class RetornarQuestaoDissertativaComRespostaResponseServiceTest {

    @InjectMocks
    RetornarQuestaoDissertativaComRespostaResponseService retornarQuestaoDissertativaComRespostaResponseService;

    @Mock
    RespostasDissertativaRepository respostasDissertativaRepository;

    @Mock
    QuestaoComRespostaMapper mapper;

    @Test
    public void deveChamarRespostasDissertativaRepositoryQuandoRetornarQuestaoDissertativaComRespostaResponseService() {

        Prova prova = new Prova();

        List<RespostasDissertativaProva> respostasDissertativaProva = new ArrayList<>();

        Mockito.when(respostasDissertativaRepository.findAllByProvaIdEquals(prova.getId())).thenReturn(respostasDissertativaProva);

        retornarQuestaoDissertativaComRespostaResponseService.buscar(prova);

        Mockito.verify(respostasDissertativaRepository).findAllByProvaIdEquals(prova.getId());
    }

    @Test
    public void deveRetornarUmaListaDeQuestaoDissertativaComRespostaResponseQuandoRetornarQuestaoDissertativaComRespostaResponseService() {

        List<QuestaoDissertativaComRespostaResponse> questoesDissertativa = new ArrayList<>();

        Prova prova = new Prova();

        List<RespostasDissertativaProva> respostasDissertativaProva = new ArrayList<>();

        Mockito.when(respostasDissertativaRepository.findAllByProvaIdEquals(prova.getId())).thenReturn(respostasDissertativaProva);

        retornarQuestaoDissertativaComRespostaResponseService.buscar(prova);

        Assert.assertEquals(questoesDissertativa, retornarQuestaoDissertativaComRespostaResponseService.buscar(prova));
    }
}