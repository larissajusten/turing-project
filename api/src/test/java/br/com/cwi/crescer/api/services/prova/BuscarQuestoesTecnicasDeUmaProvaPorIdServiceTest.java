package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.QuestaoTecnicaResponse;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoTecnica;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoTecnicaRepository;
import br.com.cwi.crescer.api.services.prova.BuscarQuestoesTecnicasDeUmaProvaPorIdService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BuscarQuestoesTecnicasDeUmaProvaPorIdServiceTest {

    @InjectMocks
    BuscarQuestoesTecnicasDeUmaProvaPorIdService buscarQuestoesTecnicasDeUmaProvaPorIdService;

    @Mock
    ProvaQuestaoTecnicaRepository repository;

    @Mock
    ModelMapper mapper;

    @Test
    public void deveChamarProvaQuestaoTecnicaRepositoryQuandoBuscarQuestoesTecnicasDeUmaProvaPorIdServiceForChamado() {
        Prova prova = new Prova();
        QuestaoTecnica questaoTecnica = new QuestaoTecnica();
        QuestaoTecnicaResponse questaoTecnicaResponse = new QuestaoTecnicaResponse();

        List<ProvaQuestaoTecnica> provaQuestaoTecnicas = new ArrayList<>();
        List<QuestaoTecnicaResponse> listaDeQuestoesTecnicasDaProva = new ArrayList<>();

        Mockito.when(repository.findAllByProvaIdEquals(prova.getId())).thenReturn(provaQuestaoTecnicas);

        buscarQuestoesTecnicasDeUmaProvaPorIdService.buscar(prova.getId());

        Mockito.verify(repository).findAllByProvaIdEquals(prova.getId());
    }

    @Test
    public void deveChamarModelMapperQuandoBuscarQuestoesTecnicasDeUmaProvaPorIdServiceForChamado() {
        Prova prova = new Prova();
        QuestaoTecnica questaoTecnica = new QuestaoTecnica();
        QuestaoTecnicaResponse questaoTecnicaResponse = new QuestaoTecnicaResponse();
        ProvaQuestaoTecnica provaQuestaoTecnica = new ProvaQuestaoTecnica();
        provaQuestaoTecnica.setQuestao(questaoTecnica);
        List<ProvaQuestaoTecnica> provaQuestaoTecnicas = new ArrayList<>();
        provaQuestaoTecnicas.add(provaQuestaoTecnica);
        List<QuestaoTecnicaResponse> listaDeQuestoesTecnicasDaProva = new ArrayList<>();

        Mockito.when(repository.findAllByProvaIdEquals(prova.getId())).thenReturn(provaQuestaoTecnicas);
        Mockito.when(mapper.map(questaoTecnica, QuestaoTecnicaResponse.class)).thenReturn(questaoTecnicaResponse);

        buscarQuestoesTecnicasDeUmaProvaPorIdService.buscar(prova.getId());

        Mockito.verify(mapper).map(questaoTecnica, QuestaoTecnicaResponse.class);
    }

    @Test
    public void deveRetornarUmaListaDeQuestaoTecnicaResponseQuandoBuscarQuestoesTecnicasDeUmaProvaPorIdServiceForChamado() {
        Prova prova = new Prova();
        QuestaoTecnica questaoTecnica = new QuestaoTecnica();
        QuestaoTecnicaResponse questaoTecnicaResponse = new QuestaoTecnicaResponse();
        ProvaQuestaoTecnica provaQuestaoTecnica = new ProvaQuestaoTecnica();
        provaQuestaoTecnica.setQuestao(questaoTecnica);
        List<ProvaQuestaoTecnica> provaQuestaoTecnicas = new ArrayList<>();
        provaQuestaoTecnicas.add(provaQuestaoTecnica);
        List<QuestaoTecnicaResponse> listaDeQuestoesTecnicasDaProva = new ArrayList<>();
        listaDeQuestoesTecnicasDaProva.add(questaoTecnicaResponse);
        Mockito.when(repository.findAllByProvaIdEquals(prova.getId())).thenReturn(provaQuestaoTecnicas);
        Mockito.when(mapper.map(questaoTecnica, QuestaoTecnicaResponse.class)).thenReturn(questaoTecnicaResponse);

        buscarQuestoesTecnicasDeUmaProvaPorIdService.buscar(prova.getId());

        Assert.assertEquals(buscarQuestoesTecnicasDeUmaProvaPorIdService.buscar(prova.getId()), listaDeQuestoesTecnicasDaProva);
    }

}