package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.ProvaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoDissertativaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoTecnicaResponse;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BuscarProvaComQuestoesServiceTest {

    @InjectMocks
    BuscarProvaComQuestoesService buscarProvaComQuestoesService;

    @Mock
    BuscarProvaPorIdService buscarProvaPorIdService;

    @Mock
    BuscarQuestoesTecnicasDeUmaProvaPorIdService buscarQuestoesTecnicasDeUmaProvaPorIdService;

    @Mock
    BuscarQuestoesDissertativasDeUmaProvaPorIdService buscarQuestoesDissertativasDeUmaProvaPorIdService;

    @Mock
    BuscarQuestoesMultiplaEscolhaDeUmaProvaPorIdService buscarQuestoesMultiplaEscolhaDeUmaProvaPorIdService;

    @Mock
    VerificarSeProvaEstaDentroDoPrazoParaIniciarService verificarSeProvaEstaDentroDoPrazoParaIniciarService;

    @Test
    public void deveChamarBuscarProvaPorIdServiceQuandoBuscarProvaComQuestoesServiceForChamado() {

        Prova prova = new Prova();
        prova.setCriador(new Usuario());
        ProvaResponse provaResponse = new ProvaResponse();
        List<QuestaoMultiplaEscolhaResponse> questoesMultiplaEscolha = new ArrayList<>();
        List<QuestaoTecnicaResponse> questoesTecnicas = new ArrayList<>();
        List<QuestaoDissertativaResponse> questoesDissertativas = new ArrayList<>();

        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);
        Mockito.when(buscarQuestoesTecnicasDeUmaProvaPorIdService.buscar(prova.getId())).thenReturn(questoesTecnicas);
        Mockito.when(buscarQuestoesDissertativasDeUmaProvaPorIdService.buscar(prova.getId())).thenReturn(questoesDissertativas);
        Mockito.when(buscarQuestoesMultiplaEscolhaDeUmaProvaPorIdService.buscar(prova.getId())).thenReturn(questoesMultiplaEscolha);
        Mockito.when(verificarSeProvaEstaDentroDoPrazoParaIniciarService.verificar(prova)).thenReturn(true);

        buscarProvaComQuestoesService.buscar(prova.getId());

        Mockito.verify(buscarProvaPorIdService).buscar(prova.getId());
    }

    @Test
    public void deveChamarBuscarQuestoesTecnicasDeUmaProvaPorIdServiceQuandoBuscarProvaComQuestoesServiceForChamado() {

        Prova prova = new Prova();
        prova.setCriador(new Usuario());
        ProvaResponse provaResponse = new ProvaResponse();
        List<QuestaoMultiplaEscolhaResponse> questoesMultiplaEscolha = new ArrayList<>();
        List<QuestaoTecnicaResponse> questoesTecnicas = new ArrayList<>();
        List<QuestaoDissertativaResponse> questoesDissertativas = new ArrayList<>();

        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);
        Mockito.when(buscarQuestoesTecnicasDeUmaProvaPorIdService.buscar(prova.getId())).thenReturn(questoesTecnicas);
        Mockito.when(buscarQuestoesDissertativasDeUmaProvaPorIdService.buscar(prova.getId())).thenReturn(questoesDissertativas);
        Mockito.when(buscarQuestoesMultiplaEscolhaDeUmaProvaPorIdService.buscar(prova.getId())).thenReturn(questoesMultiplaEscolha);
        Mockito.when(verificarSeProvaEstaDentroDoPrazoParaIniciarService.verificar(prova)).thenReturn(true);

        buscarProvaComQuestoesService.buscar(prova.getId());

        Mockito.verify(buscarQuestoesTecnicasDeUmaProvaPorIdService).buscar(prova.getId());
    }

    @Test
    public void deveChamarBuscarQuestoesDissertativasDeUmaProvaPorIdServiceQuandoBuscarProvaComQuestoesServiceForChamado() {

        Prova prova = new Prova();
        prova.setCriador(new Usuario());
        ProvaResponse provaResponse = new ProvaResponse();
        List<QuestaoMultiplaEscolhaResponse> questoesMultiplaEscolha = new ArrayList<>();
        List<QuestaoTecnicaResponse> questoesTecnicas = new ArrayList<>();
        List<QuestaoDissertativaResponse> questoesDissertativas = new ArrayList<>();

        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);
        Mockito.when(buscarQuestoesTecnicasDeUmaProvaPorIdService.buscar(prova.getId())).thenReturn(questoesTecnicas);
        Mockito.when(buscarQuestoesDissertativasDeUmaProvaPorIdService.buscar(prova.getId())).thenReturn(questoesDissertativas);
        Mockito.when(buscarQuestoesMultiplaEscolhaDeUmaProvaPorIdService.buscar(prova.getId())).thenReturn(questoesMultiplaEscolha);
        Mockito.when(verificarSeProvaEstaDentroDoPrazoParaIniciarService.verificar(prova)).thenReturn(true);

        buscarProvaComQuestoesService.buscar(prova.getId());

        Mockito.verify(buscarQuestoesDissertativasDeUmaProvaPorIdService).buscar(prova.getId());
    }

    @Test
    public void deveChamarBuscarQuestoesMultiplaEscolhaDeUmaProvaPorIdServiceQuandoBuscarProvaComQuestoesServiceForChamado() {

        Prova prova = new Prova();
        prova.setCriador(new Usuario());
        ProvaResponse provaResponse = new ProvaResponse();
        List<QuestaoMultiplaEscolhaResponse> questoesMultiplaEscolha = new ArrayList<>();
        List<QuestaoTecnicaResponse> questoesTecnicas = new ArrayList<>();
        List<QuestaoDissertativaResponse> questoesDissertativas = new ArrayList<>();

        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);
        Mockito.when(buscarQuestoesTecnicasDeUmaProvaPorIdService.buscar(prova.getId())).thenReturn(questoesTecnicas);
        Mockito.when(buscarQuestoesDissertativasDeUmaProvaPorIdService.buscar(prova.getId())).thenReturn(questoesDissertativas);
        Mockito.when(buscarQuestoesMultiplaEscolhaDeUmaProvaPorIdService.buscar(prova.getId())).thenReturn(questoesMultiplaEscolha);
        Mockito.when(verificarSeProvaEstaDentroDoPrazoParaIniciarService.verificar(prova)).thenReturn(true);

        buscarProvaComQuestoesService.buscar(prova.getId());

        Mockito.verify(buscarQuestoesMultiplaEscolhaDeUmaProvaPorIdService).buscar(prova.getId());
    }
}