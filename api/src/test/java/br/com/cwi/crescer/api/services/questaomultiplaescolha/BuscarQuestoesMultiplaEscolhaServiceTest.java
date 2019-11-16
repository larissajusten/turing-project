package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.controller.responses.AlternativaMultiplaEscolhaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaResponse;
import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.exception.questoes.QuestaoNaoEncontradaException;
import br.com.cwi.crescer.api.mapper.AlternativaMultiplaEscolhaMapper;
import br.com.cwi.crescer.api.mapper.QuestaoMultiplaEscolhaMapper;
import br.com.cwi.crescer.api.repository.questao.QuestaoMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.services.alternativamultiplaescolha.BuscarAlternativaQuestaoMultiplaEscolhaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BuscarQuestoesMultiplaEscolhaServiceTest {

    @InjectMocks
    private BuscarQuestoesMultiplaEscolhaService buscarQuestoesMultiplaEscolhaService;

    @Mock
    QuestaoMultiplaEscolhaMapper mapper;

    @Mock
    BuscarAlternativaQuestaoMultiplaEscolhaService buscarAlternativaQuestaoMultiplaEscolhaService;

    @Mock
    QuestaoMultiplaEscolhaRepository repository;

    @Mock
    AlternativaMultiplaEscolhaMapper mapperAlternativa;

    @Test
    public void deveChamarRepositoryQuandoBuscarQuestoesMultiplaEscolhaForChamada() {

        PageRequest page = PageRequest.of(1, 10);

        QuestaoMultiplaEscolha questao = new QuestaoMultiplaEscolha();
        QuestaoMultiplaEscolhaResponse questaoResponse = new QuestaoMultiplaEscolhaResponse();
        List<QuestaoMultiplaEscolha> questoesMultiplaEscolha = new ArrayList<>();
        questoesMultiplaEscolha.add(questao);

        AlternativaMultiplaEscolha alternativa = new AlternativaMultiplaEscolha();
        AlternativaMultiplaEscolhaResponse alternativaResponse = new AlternativaMultiplaEscolhaResponse();
        Page<QuestaoMultiplaEscolha> questoes = new PageImpl<QuestaoMultiplaEscolha>(questoesMultiplaEscolha, page, questoesMultiplaEscolha.size());

        List<AlternativaMultiplaEscolha> alternativas = new ArrayList<>();
        List<AlternativaMultiplaEscolhaResponse> alternativasResponse = new ArrayList<>();

        alternativas.add(alternativa);

        Mockito.when(repository.findAll(page)).thenReturn(questoes);
        Mockito.when(buscarAlternativaQuestaoMultiplaEscolhaService.buscar(questao.getId())).thenReturn(alternativas);
        Mockito.when(mapperAlternativa.transformarEmResponse(alternativa)).thenReturn(alternativaResponse);

        buscarQuestoesMultiplaEscolhaService.buscarTodasQuestoes(page);

        Mockito.verify(repository).findAll(page);

    }

    @Test
    public void deveChamarQuestaoMultiplaEscolhaMapperQuandoBuscarQuestoesMultiplaEscolhaForChamada() {

        PageRequest page = PageRequest.of(1, 10);

        QuestaoMultiplaEscolha questao = new QuestaoMultiplaEscolha();
        QuestaoMultiplaEscolhaResponse questaoResponse = new QuestaoMultiplaEscolhaResponse();
        List<QuestaoMultiplaEscolha> questoesMultiplaEscolha = new ArrayList<>();
        questoesMultiplaEscolha.add(questao);

        AlternativaMultiplaEscolha alternativa = new AlternativaMultiplaEscolha();
        AlternativaMultiplaEscolhaResponse alternativaResponse = new AlternativaMultiplaEscolhaResponse();

        Page<QuestaoMultiplaEscolha> questoes = new PageImpl<QuestaoMultiplaEscolha>(questoesMultiplaEscolha, page, questoesMultiplaEscolha.size());

        List<AlternativaMultiplaEscolha> alternativas = new ArrayList<>();
        List<AlternativaMultiplaEscolhaResponse> alternativasResponse = new ArrayList<>();

        Mockito.when(repository.findAll(page)).thenReturn(questoes);
        Mockito.when(buscarAlternativaQuestaoMultiplaEscolhaService.buscar(questao.getId())).thenReturn(alternativas);

        buscarQuestoesMultiplaEscolhaService.buscarTodasQuestoes(page);

        Mockito.verify(mapper).transformarParaResponse(questao, alternativasResponse);

    }

    @Test
    public void deveChamarBuscarAlternativaQuestaoMultiplaEscolhaQuandoBuscarQuestoesMultiplaEscolhaForChamada() {

        PageRequest page = PageRequest.of(1, 10);

        QuestaoMultiplaEscolha questao = new QuestaoMultiplaEscolha();
        QuestaoMultiplaEscolhaResponse questaoResponse = new QuestaoMultiplaEscolhaResponse();
        List<QuestaoMultiplaEscolha> questoesMultiplaEscolha = new ArrayList<>();
        questoesMultiplaEscolha.add(questao);

        AlternativaMultiplaEscolha alternativa = new AlternativaMultiplaEscolha();
        AlternativaMultiplaEscolhaResponse alternativaResponse = new AlternativaMultiplaEscolhaResponse();

        Page<QuestaoMultiplaEscolha> questoes = new PageImpl<QuestaoMultiplaEscolha>(questoesMultiplaEscolha, page, questoesMultiplaEscolha.size());

        List<AlternativaMultiplaEscolha> alternativas = new ArrayList<>();
        List<AlternativaMultiplaEscolhaResponse> alternativasResponse = new ArrayList<>();

        alternativas.add(alternativa);

        Mockito.when(repository.findAll(page)).thenReturn(questoes);
        Mockito.when(mapperAlternativa.transformarEmResponse(alternativa)).thenReturn(alternativaResponse);
        Mockito.when(buscarAlternativaQuestaoMultiplaEscolhaService.buscar(questao.getId())).thenReturn(alternativas);
        buscarQuestoesMultiplaEscolhaService.buscarTodasQuestoes(page);

        Mockito.verify(buscarAlternativaQuestaoMultiplaEscolhaService).buscar(questao.getId());

    }

    @Test(expected = QuestaoNaoEncontradaException.class)
    public void deveLancarUmaExceptionQuandoBuscarQuestoesMultiplaEscolhaForChamadaEVoltarVazia() {

        PageRequest page = PageRequest.of(1, 10);

        QuestaoMultiplaEscolha questao = new QuestaoMultiplaEscolha();
        QuestaoMultiplaEscolhaResponse questaoResponse = new QuestaoMultiplaEscolhaResponse();
        List<QuestaoMultiplaEscolha> questoesMultiplaEscolha = new ArrayList<>();

        AlternativaMultiplaEscolha alternativa = new AlternativaMultiplaEscolha();

        Page<QuestaoMultiplaEscolha> questoes = new PageImpl<QuestaoMultiplaEscolha>(questoesMultiplaEscolha, page, questoesMultiplaEscolha.size());

        List<AlternativaMultiplaEscolha> alternativas = new ArrayList<>();
        alternativas.add(alternativa);

        Mockito.when(repository.findAll(page)).thenReturn(questoes);
        buscarQuestoesMultiplaEscolhaService.buscarTodasQuestoes(page);


    }


}