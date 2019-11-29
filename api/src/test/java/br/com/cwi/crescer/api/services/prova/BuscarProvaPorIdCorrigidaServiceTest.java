package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.ProvaCorrigidaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoDissertativaComRespostaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaComRespostaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoTecnicaComRespostaResponse;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.services.respostaprova.RetornarQuestaoDissertativaComRespostaResponseService;
import br.com.cwi.crescer.api.services.respostaprova.RetornarQuestaoMultiplaEscolhaComRespostaResponseService;
import br.com.cwi.crescer.api.services.respostaprova.RetornarQuestaoTecnicaComRespostaResponseService;
import br.com.cwi.crescer.api.validator.ProvasVaziaValidador;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BuscarProvaPorIdCorrigidaServiceTest {

    @InjectMocks
    BuscarProvaPorIdCorrigidaService buscarProvaPorIdCorrigidaService;

    @Mock
    BuscarProvaPorIdService buscarProvaPorIdService;

    @Mock
    RetornarQuestaoTecnicaComRespostaResponseService retornarQuestaoTecnicaComRespostaResponseService;

    @Mock
    RetornarQuestaoDissertativaComRespostaResponseService retornarQuestaoDissertativaComRespostaResponseService;

    @Mock
    RetornarQuestaoMultiplaEscolhaComRespostaResponseService retornarQuestaoMultiplaEscolhaComRespostaResponseService;

    @Mock
    RetornarListaDeEspecifidadesDeUmaProvaService retornarListaDeEspecifidadesDeUmaProvaService;

    @Mock
    ProvasVaziaValidador validator;

    @Test
    public void deveChamarRetornarQuestaoTecnicaComRespostaResponseServiceQuandoBuscarProvaPorIdCorrigidaServiceForChamado() {
        ProvaCorrigidaResponse provaCorrigidaResponse = new ProvaCorrigidaResponse();
        Prova prova = new Prova();
        prova.setStatus(StatusProva.CORRIGIDA);
        prova.setTempoDeDuracaoDaProva(2);
        prova.setDataInicio(LocalDateTime.now());
        prova.setTempoParaInicioProva(1);
        prova.setEmailCandidato("Mail@mail.com");
        prova.setNomeCandidato("Ruberval");
        prova.setNota(10);

        List<QuestaoTecnicaComRespostaResponse> questoesTecnicas = new ArrayList<>();
        List<QuestaoDissertativaComRespostaResponse> questaoDissertativa = new ArrayList<>();
        List<QuestaoMultiplaEscolhaComRespostaResponse> questaoMultiplaEscolha = new ArrayList<>();

        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);
        Mockito.when(retornarQuestaoTecnicaComRespostaResponseService.buscar(prova)).thenReturn(questoesTecnicas);
        Mockito.when(retornarQuestaoDissertativaComRespostaResponseService.buscar(prova)).thenReturn(questaoDissertativa);
        Mockito.when(retornarQuestaoMultiplaEscolhaComRespostaResponseService.buscar(prova)).thenReturn(questaoMultiplaEscolha);

        buscarProvaPorIdCorrigidaService.buscar(prova.getId());

        Mockito.verify(retornarQuestaoTecnicaComRespostaResponseService).buscar(prova);

    }

    @Test
    public void deveChamarRetornarQuestaoDissertativaComRespostaResponseServiceQuandoBuscarProvaPorIdCorrigidaServiceForChamado() {
        ProvaCorrigidaResponse provaCorrigidaResponse = new ProvaCorrigidaResponse();
        Prova prova = new Prova();
        prova.setStatus(StatusProva.CORRIGIDA);
        prova.setTempoDeDuracaoDaProva(2);
        prova.setDataInicio(LocalDateTime.now());
        prova.setTempoParaInicioProva(1);
        prova.setEmailCandidato("Mail@mail.com");
        prova.setNomeCandidato("Ruberval");
        prova.setNota(10);

        List<QuestaoTecnicaComRespostaResponse> questoesTecnicas = new ArrayList<>();
        List<QuestaoDissertativaComRespostaResponse> questaoDissertativa = new ArrayList<>();
        List<QuestaoMultiplaEscolhaComRespostaResponse> questaoMultiplaEscolha = new ArrayList<>();

        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);
        Mockito.when(retornarQuestaoTecnicaComRespostaResponseService.buscar(prova)).thenReturn(questoesTecnicas);
        Mockito.when(retornarQuestaoDissertativaComRespostaResponseService.buscar(prova)).thenReturn(questaoDissertativa);
        Mockito.when(retornarQuestaoMultiplaEscolhaComRespostaResponseService.buscar(prova)).thenReturn(questaoMultiplaEscolha);

        buscarProvaPorIdCorrigidaService.buscar(prova.getId());

        Mockito.verify(retornarQuestaoDissertativaComRespostaResponseService).buscar(prova);

    }

    @Test
    public void deveChamarRetornarQuestaoMultiplaEscolhaComRespostaResponseServiceQuandoBuscarProvaPorIdCorrigidaServiceForChamado() {
        ProvaCorrigidaResponse provaCorrigidaResponse = new ProvaCorrigidaResponse();
        Prova prova = new Prova();
        prova.setStatus(StatusProva.CORRIGIDA);
        prova.setTempoDeDuracaoDaProva(2);
        prova.setDataInicio(LocalDateTime.now());
        prova.setTempoParaInicioProva(1);
        prova.setEmailCandidato("Mail@mail.com");
        prova.setNomeCandidato("Ruberval");
        prova.setNota(10);

        List<QuestaoTecnicaComRespostaResponse> questoesTecnicas = new ArrayList<>();
        List<QuestaoDissertativaComRespostaResponse> questaoDissertativa = new ArrayList<>();
        List<QuestaoMultiplaEscolhaComRespostaResponse> questaoMultiplaEscolha = new ArrayList<>();

        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);
        Mockito.when(retornarQuestaoTecnicaComRespostaResponseService.buscar(prova)).thenReturn(questoesTecnicas);
        Mockito.when(retornarQuestaoDissertativaComRespostaResponseService.buscar(prova)).thenReturn(questaoDissertativa);
        Mockito.when(retornarQuestaoMultiplaEscolhaComRespostaResponseService.buscar(prova)).thenReturn(questaoMultiplaEscolha);

        buscarProvaPorIdCorrigidaService.buscar(prova.getId());

        Mockito.verify(retornarQuestaoMultiplaEscolhaComRespostaResponseService).buscar(prova);

    }


    @Test
    public void deveRetornarProvaCorrigidaResponseQuandoBuscarProvaPorIdCorrigidaServiceForChamado() {

        ProvaCorrigidaResponse provaCorrigidaResponse = new ProvaCorrigidaResponse();
        Prova prova = new Prova();
        prova.setStatus(StatusProva.CORRIGIDA);
        prova.setTempoDeDuracaoDaProva(2);
        prova.setDataInicio(LocalDateTime.now());
        prova.setTempoParaInicioProva(1);
        prova.setEmailCandidato("Mail@mail.com");
        prova.setNomeCandidato("Ruberval");
        prova.setNota(10);

        List<QuestaoTecnicaComRespostaResponse> questoesTecnicas = new ArrayList<>();
        List<QuestaoDissertativaComRespostaResponse> questaoDissertativa = new ArrayList<>();
        List<QuestaoMultiplaEscolhaComRespostaResponse> questaoMultiplaEscolha = new ArrayList<>();

        provaCorrigidaResponse.setTempoDeDuracaoDaProva(prova.getTempoDeDuracaoDaProva());
        provaCorrigidaResponse.setQuestoesTecnicas(questoesTecnicas);
        provaCorrigidaResponse.setQuestoesDissertativas(questaoDissertativa);
        provaCorrigidaResponse.setQuestoesMultiplaEscolha(questaoMultiplaEscolha);
        provaCorrigidaResponse.setNota(prova.getNota());
        provaCorrigidaResponse.setNomeCandidato(prova.getNomeCandidato());
        provaCorrigidaResponse.setDataCriacao(prova.getDataCriacao());
        provaCorrigidaResponse.setDataInicio(prova.getDataInicio());
        provaCorrigidaResponse.setEmailCandidato(prova.getEmailCandidato());
        provaCorrigidaResponse.setStatusProva(prova.getStatus());
        provaCorrigidaResponse.setTempoParaInicioProva(prova.getTempoParaInicioProva());
        provaCorrigidaResponse.setEspecificidades(new ArrayList<>());

        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);
        Mockito.when(retornarQuestaoTecnicaComRespostaResponseService.buscar(prova)).thenReturn(questoesTecnicas);
        Mockito.when(retornarQuestaoDissertativaComRespostaResponseService.buscar(prova)).thenReturn(questaoDissertativa);
        Mockito.when(retornarQuestaoMultiplaEscolhaComRespostaResponseService.buscar(prova)).thenReturn(questaoMultiplaEscolha);

        Assert.assertEquals(provaCorrigidaResponse, buscarProvaPorIdCorrigidaService.buscar(prova.getId()));

    }

}