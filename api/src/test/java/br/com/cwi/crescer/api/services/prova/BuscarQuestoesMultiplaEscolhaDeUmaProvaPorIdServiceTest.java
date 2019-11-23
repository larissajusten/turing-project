package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.AlternativaMultiplaEscolhaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaResponse;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.mapper.AlternativaMultiplaEscolhaMapper;
import br.com.cwi.crescer.api.mapper.QuestaoMultiplaEscolhaMapper;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.services.alternativamultiplaescolha.BuscarAlternativaQuestaoMultiplaEscolhaService;
import br.com.cwi.crescer.api.services.provaquestao.BuscarQuestoesMultiplaEscolhaDeUmaProvaPorIdService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BuscarQuestoesMultiplaEscolhaDeUmaProvaPorIdServiceTest {

    @InjectMocks
    BuscarQuestoesMultiplaEscolhaDeUmaProvaPorIdService buscarQuestoesMultiplaEscolhaDeUmaProvaPorIdService;

    @Mock
    ProvaQuestaoMultiplaEscolhaRepository repository;

    @Mock
    BuscarAlternativaQuestaoMultiplaEscolhaService buscarAlternativaQuestaoMultiplaEscolhaService;

    @Mock
    QuestaoMultiplaEscolhaMapper mapperQuestaoMultiplaEscolha;

    @Mock
    AlternativaMultiplaEscolhaMapper mapperAlternativaMultiplaEscolha;

    @Test
    public void deveChamarProvaQuestaoMultiplaEscolhaRepositoryQuandoBuscarQuestoesMultiplaEscolhaDeUmaProvaPorIdServiceForChamado() {

        Prova prova = new Prova();
        List<QuestaoMultiplaEscolhaResponse> questoes = new ArrayList<>();
        List<ProvaQuestaoMultiplaEscolha> provaQuestaoMultiplaEscolhas = new ArrayList<>();
        List<AlternativaMultiplaEscolha> listaAlternativasMultiplaEscolha = new ArrayList<>();
        List<AlternativaMultiplaEscolhaResponse> alternativaMultiplaEscolhaResponses = new ArrayList<>();
        ProvaQuestaoMultiplaEscolha provaQuestaoMultiplaEscolha = new ProvaQuestaoMultiplaEscolha();
        QuestaoMultiplaEscolha questaoMultiplaEscolha = new QuestaoMultiplaEscolha();
        QuestaoMultiplaEscolhaResponse questaoMultiplaEscolhaResponse = new QuestaoMultiplaEscolhaResponse();
        AlternativaMultiplaEscolha alternativaMultiplaEscolha = new AlternativaMultiplaEscolha();
        AlternativaMultiplaEscolhaResponse alternativaMultiplaEscolhaResponse = new AlternativaMultiplaEscolhaResponse();


        Mockito.when(repository.findAllByProvaIdEquals(prova.getId())).thenReturn(provaQuestaoMultiplaEscolhas);

        buscarQuestoesMultiplaEscolhaDeUmaProvaPorIdService.buscar(prova.getId());

        Mockito.verify(repository).findAllByProvaIdEquals(prova.getId());
    }


    @Test
    public void deveChamarBuscarAlternativaQuestaoMultiplaEscolhaServiceQuandoBuscarQuestoesMultiplaEscolhaDeUmaProvaPorIdServiceForChamado() {

        Prova prova = new Prova();
        QuestaoMultiplaEscolha questaoMultiplaEscolha = new QuestaoMultiplaEscolha();
        QuestaoMultiplaEscolhaResponse questaoMultiplaEscolhaResponse = new QuestaoMultiplaEscolhaResponse();
        AlternativaMultiplaEscolha alternativaMultiplaEscolha = new AlternativaMultiplaEscolha();
        AlternativaMultiplaEscolhaResponse alternativaMultiplaEscolhaResponse = new AlternativaMultiplaEscolhaResponse();

        ProvaQuestaoMultiplaEscolha provaQuestaoMultiplaEscolha = new ProvaQuestaoMultiplaEscolha();
        provaQuestaoMultiplaEscolha.setQuestao(questaoMultiplaEscolha);
        provaQuestaoMultiplaEscolha.setProva(prova);

        List<QuestaoMultiplaEscolhaResponse> questoes = new ArrayList<>();
        List<ProvaQuestaoMultiplaEscolha> provaQuestaoMultiplaEscolhas = new ArrayList<>();
        provaQuestaoMultiplaEscolhas.add(provaQuestaoMultiplaEscolha);
        List<AlternativaMultiplaEscolha> listaAlternativasMultiplaEscolha = new ArrayList<>();
        listaAlternativasMultiplaEscolha.add(alternativaMultiplaEscolha);
        List<AlternativaMultiplaEscolhaResponse> alternativaMultiplaEscolhaResponses = new ArrayList<>();
        alternativaMultiplaEscolhaResponses.add(alternativaMultiplaEscolhaResponse);

        Mockito.when(repository.findAllByProvaIdEquals(prova.getId())).thenReturn(provaQuestaoMultiplaEscolhas);
        Mockito.when(buscarAlternativaQuestaoMultiplaEscolhaService.buscar(provaQuestaoMultiplaEscolha.getId())).thenReturn(listaAlternativasMultiplaEscolha);
        Mockito.when(mapperAlternativaMultiplaEscolha.transformarEmResponse(alternativaMultiplaEscolha)).thenReturn(alternativaMultiplaEscolhaResponse);
        Mockito.when(mapperQuestaoMultiplaEscolha.transformarParaResponse(questaoMultiplaEscolha, alternativaMultiplaEscolhaResponses)).thenReturn(questaoMultiplaEscolhaResponse);

        buscarQuestoesMultiplaEscolhaDeUmaProvaPorIdService.buscar(prova.getId());

        Mockito.verify(buscarAlternativaQuestaoMultiplaEscolhaService).buscar(provaQuestaoMultiplaEscolha.getId());
    }

    @Test
    public void deveChamarAlternativaMultiplaEscolhaMapperQuandoBuscarQuestoesMultiplaEscolhaDeUmaProvaPorIdServiceForChamado() {

        Prova prova = new Prova();
        QuestaoMultiplaEscolha questaoMultiplaEscolha = new QuestaoMultiplaEscolha();
        QuestaoMultiplaEscolhaResponse questaoMultiplaEscolhaResponse = new QuestaoMultiplaEscolhaResponse();
        AlternativaMultiplaEscolha alternativaMultiplaEscolha = new AlternativaMultiplaEscolha();
        AlternativaMultiplaEscolhaResponse alternativaMultiplaEscolhaResponse = new AlternativaMultiplaEscolhaResponse();

        ProvaQuestaoMultiplaEscolha provaQuestaoMultiplaEscolha = new ProvaQuestaoMultiplaEscolha();
        provaQuestaoMultiplaEscolha.setQuestao(questaoMultiplaEscolha);
        provaQuestaoMultiplaEscolha.setProva(prova);

        List<QuestaoMultiplaEscolhaResponse> questoes = new ArrayList<>();
        List<ProvaQuestaoMultiplaEscolha> provaQuestaoMultiplaEscolhas = new ArrayList<>();
        provaQuestaoMultiplaEscolhas.add(provaQuestaoMultiplaEscolha);
        List<AlternativaMultiplaEscolha> listaAlternativasMultiplaEscolha = new ArrayList<>();
        listaAlternativasMultiplaEscolha.add(alternativaMultiplaEscolha);
        List<AlternativaMultiplaEscolhaResponse> alternativaMultiplaEscolhaResponses = new ArrayList<>();
        alternativaMultiplaEscolhaResponses.add(alternativaMultiplaEscolhaResponse);

        Mockito.when(repository.findAllByProvaIdEquals(prova.getId())).thenReturn(provaQuestaoMultiplaEscolhas);
        Mockito.when(buscarAlternativaQuestaoMultiplaEscolhaService.buscar(provaQuestaoMultiplaEscolha.getId())).thenReturn(listaAlternativasMultiplaEscolha);
        Mockito.when(mapperAlternativaMultiplaEscolha.transformarEmResponse(alternativaMultiplaEscolha)).thenReturn(alternativaMultiplaEscolhaResponse);
        Mockito.when(mapperQuestaoMultiplaEscolha.transformarParaResponse(questaoMultiplaEscolha, alternativaMultiplaEscolhaResponses)).thenReturn(questaoMultiplaEscolhaResponse);

        buscarQuestoesMultiplaEscolhaDeUmaProvaPorIdService.buscar(prova.getId());

        Mockito.verify(mapperAlternativaMultiplaEscolha).transformarEmResponse(alternativaMultiplaEscolha);
    }

    @Test
    public void deveChamarQuestaoMultiplaEscolhaMapperQuandoBuscarQuestoesMultiplaEscolhaDeUmaProvaPorIdServiceForChamado() {

        Prova prova = new Prova();
        QuestaoMultiplaEscolha questaoMultiplaEscolha = new QuestaoMultiplaEscolha();
        QuestaoMultiplaEscolhaResponse questaoMultiplaEscolhaResponse = new QuestaoMultiplaEscolhaResponse();
        AlternativaMultiplaEscolha alternativaMultiplaEscolha = new AlternativaMultiplaEscolha();
        AlternativaMultiplaEscolhaResponse alternativaMultiplaEscolhaResponse = new AlternativaMultiplaEscolhaResponse();

        ProvaQuestaoMultiplaEscolha provaQuestaoMultiplaEscolha = new ProvaQuestaoMultiplaEscolha();
        provaQuestaoMultiplaEscolha.setQuestao(questaoMultiplaEscolha);
        provaQuestaoMultiplaEscolha.setProva(prova);

        List<QuestaoMultiplaEscolhaResponse> questoes = new ArrayList<>();
        List<ProvaQuestaoMultiplaEscolha> provaQuestaoMultiplaEscolhas = new ArrayList<>();
        provaQuestaoMultiplaEscolhas.add(provaQuestaoMultiplaEscolha);
        List<AlternativaMultiplaEscolha> listaAlternativasMultiplaEscolha = new ArrayList<>();
        listaAlternativasMultiplaEscolha.add(alternativaMultiplaEscolha);
        List<AlternativaMultiplaEscolhaResponse> alternativaMultiplaEscolhaResponses = new ArrayList<>();
        alternativaMultiplaEscolhaResponses.add(alternativaMultiplaEscolhaResponse);

        Mockito.when(repository.findAllByProvaIdEquals(prova.getId())).thenReturn(provaQuestaoMultiplaEscolhas);
        Mockito.when(buscarAlternativaQuestaoMultiplaEscolhaService.buscar(provaQuestaoMultiplaEscolha.getId())).thenReturn(listaAlternativasMultiplaEscolha);
        Mockito.when(mapperAlternativaMultiplaEscolha.transformarEmResponse(alternativaMultiplaEscolha)).thenReturn(alternativaMultiplaEscolhaResponse);
        Mockito.when(mapperQuestaoMultiplaEscolha.transformarParaResponse(questaoMultiplaEscolha, alternativaMultiplaEscolhaResponses)).thenReturn(questaoMultiplaEscolhaResponse);

        buscarQuestoesMultiplaEscolhaDeUmaProvaPorIdService.buscar(prova.getId());

        Mockito.verify(mapperQuestaoMultiplaEscolha).transformarParaResponse(questaoMultiplaEscolha, alternativaMultiplaEscolhaResponses);
    }

}