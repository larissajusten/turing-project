package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaComRespostaResponse;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.resposta.RespostasMultiplaEscolhaProva;
import br.com.cwi.crescer.api.mapper.QuestaoComRespostaMapper;
import br.com.cwi.crescer.api.repository.resposta.RespostaMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.services.questaomultiplaescolha.RetornarNotaDaQuestaoMultiplaEscolhaService;
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
public class RetornarQuestaoMultiplaEscolhaComRespostaResponseServiceTest {

    @InjectMocks
    RetornarQuestaoMultiplaEscolhaComRespostaResponseService retornarQuestaoMultiplaEscolhaComRespostaResponseService;

    @Mock
    RespostaMultiplaEscolhaRepository respostaMultiplaEscolhaRepository;

    @Mock
    RetornarNotaDaQuestaoMultiplaEscolhaService retornarNotaDaQuestaoMultiplaEscolhaService;

    @Mock
    QuestaoComRespostaMapper mapper;

    @Test
    public void deveChamarQuestaoComRespostaMapperQuandoRetornarQuestaoMultiplaEscolhaComRespostaResponseServiceForChamado() {

        QuestaoMultiplaEscolhaComRespostaResponse questaoMultiplaEscolhaComRespostaResponse = new QuestaoMultiplaEscolhaComRespostaResponse();
        RespostasMultiplaEscolhaProva respostaMultiplaEscolhaProva = new RespostasMultiplaEscolhaProva();

        Prova prova = new Prova();

        List<RespostasMultiplaEscolhaProva> respostasMultiplaEscolhaProva = new ArrayList<>();
        respostasMultiplaEscolhaProva.add(respostaMultiplaEscolhaProva);
        respostaMultiplaEscolhaProva.setProva(prova);

        Mockito.when(mapper.questaoMultiplaEscolha(respostaMultiplaEscolhaProva)).thenReturn(questaoMultiplaEscolhaComRespostaResponse);
        Mockito.when(respostaMultiplaEscolhaRepository.findAllByProvaIdEquals(prova.getId())).thenReturn(respostasMultiplaEscolhaProva);

        retornarQuestaoMultiplaEscolhaComRespostaResponseService.buscar(prova);

        Mockito.verify(mapper).questaoMultiplaEscolha(respostaMultiplaEscolhaProva);
    }

    @Test
    public void deveRetornarUmaListaDeQuestaoMultiplaEscolhaComRespostaResponseQuandoRetornarQuestaoMultiplaEscolhaComRespostaResponseServiceForChamado() {

        QuestaoMultiplaEscolhaComRespostaResponse questaoMultiplaEscolhaComRespostaResponse = new QuestaoMultiplaEscolhaComRespostaResponse();
        RespostasMultiplaEscolhaProva respostaMultiplaEscolhaProva = new RespostasMultiplaEscolhaProva();

        Prova prova = new Prova();
        List<QuestaoMultiplaEscolhaComRespostaResponse> questaoMultiplaEscolhaComRespostaResponses =
                new ArrayList<>();
        questaoMultiplaEscolhaComRespostaResponses.add(questaoMultiplaEscolhaComRespostaResponse);

        List<RespostasMultiplaEscolhaProva> respostasMultiplaEscolhaProva = new ArrayList<>();
        respostasMultiplaEscolhaProva.add(respostaMultiplaEscolhaProva);
        respostaMultiplaEscolhaProva.setProva(prova);

        Mockito.when(mapper.questaoMultiplaEscolha(respostaMultiplaEscolhaProva)).thenReturn(questaoMultiplaEscolhaComRespostaResponse);
        Mockito.when(respostaMultiplaEscolhaRepository.findAllByProvaIdEquals(prova.getId())).thenReturn(respostasMultiplaEscolhaProva);

        retornarQuestaoMultiplaEscolhaComRespostaResponseService.buscar(prova);

        Assert.assertEquals(questaoMultiplaEscolhaComRespostaResponses, retornarQuestaoMultiplaEscolhaComRespostaResponseService.buscar(prova));
    }

}