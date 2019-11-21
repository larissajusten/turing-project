package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.ProvaCorrigidaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoDissertativaComRespostaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaComRespostaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoTecnicaComRespostaResponse;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
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
public class BuscarProvasCorrigidasComNotaServiceTest {

    @InjectMocks
    BuscarProvasCorrigidasComNotaService buscarProvasCorrigidasComNotaService;

    @Mock
    ProvaRepository provaRepository;

    @Mock
    RetornarQuestaoTecnicaComRespostaResponseService retornarQuestaoTecnicaComRespostaResponseService;

    @Mock
    RetornarQuestaoDissertativaComRespostaResponseService retornarQuestaoDissertativaComRespostaResponseService;

    @Mock
    RetornarQuestaoMultiplaEscolhaComRespostaResponseService retornarQuestaoMultiplaEscolhaComRespostaResponseService;


    @Test
    public void deveChamarProvaRepositoryQuandoBuscarProvasCorrigidasComNotaServiceForChamado() {

        PageRequest page = PageRequest.of(1, 10);
        ProvaCorrigidaResponse provaResponse = new ProvaCorrigidaResponse();

        Prova prova = new Prova();
        prova.setId(1L);
        prova.setStatus(StatusProva.CORRIGIDA);

        ProvaCorrigidaResponse provaCorrigidaResponse = new ProvaCorrigidaResponse();

        List<Prova> provasList = new ArrayList<>();
        provasList.add(prova);

        List<ProvaCorrigidaResponse> provaCorrigida = new ArrayList<>();
        provaCorrigida.add(provaCorrigidaResponse);

        List<QuestaoTecnicaComRespostaResponse> questoesTecnicas = new ArrayList<>();

        List<QuestaoDissertativaComRespostaResponse> questaoDissertativa = new ArrayList<>();

        List<QuestaoMultiplaEscolhaComRespostaResponse> questaoMultiplaEscolha = new ArrayList<>();

        provaResponse.setQuestoesDissertativas(questaoDissertativa);
        provaResponse.setQuestoesMultiplaEscolha(questaoMultiplaEscolha);
        provaResponse.setQuestoesTecnicas(questoesTecnicas);

        Page<Prova> provas = new PageImpl<>(provasList, page, provasList.size());
        Page<ProvaCorrigidaResponse> provaCorrigidaResponsePage = new PageImpl<>(provaCorrigida, page, provaCorrigida.size());

        Mockito.when(provaRepository.findAllByStatusEquals(page, StatusProva.CORRIGIDA)).thenReturn(provas);
        Mockito.when(retornarQuestaoTecnicaComRespostaResponseService.buscar(prova)).thenReturn(questoesTecnicas);
        Mockito.when(retornarQuestaoDissertativaComRespostaResponseService.buscar(prova)).thenReturn(questaoDissertativa);
        Mockito.when(retornarQuestaoMultiplaEscolhaComRespostaResponseService.buscar(prova)).thenReturn(questaoMultiplaEscolha);

        buscarProvasCorrigidasComNotaService.buscar(page);

        Mockito.verify(provaRepository).findAllByStatusEquals(page, StatusProva.CORRIGIDA);
    }

    @Test
    public void deveChamarRetornarQuestaoTecnicaComRespostaResponseServiceQuandoBuscarProvasCorrigidasComNotaServiceForChamado() {

        PageRequest page = PageRequest.of(1, 10);
        ProvaCorrigidaResponse provaResponse = new ProvaCorrigidaResponse();

        Prova prova = new Prova();
        prova.setId(1L);
        prova.setStatus(StatusProva.CORRIGIDA);

        ProvaCorrigidaResponse provaCorrigidaResponse = new ProvaCorrigidaResponse();

        List<Prova> provasList = new ArrayList<>();
        provasList.add(prova);

        List<ProvaCorrigidaResponse> provaCorrigida = new ArrayList<>();
        provaCorrigida.add(provaCorrigidaResponse);

        List<QuestaoTecnicaComRespostaResponse> questoesTecnicas = new ArrayList<>();

        List<QuestaoDissertativaComRespostaResponse> questaoDissertativa = new ArrayList<>();

        List<QuestaoMultiplaEscolhaComRespostaResponse> questaoMultiplaEscolha = new ArrayList<>();

        provaResponse.setQuestoesDissertativas(questaoDissertativa);
        provaResponse.setQuestoesMultiplaEscolha(questaoMultiplaEscolha);
        provaResponse.setQuestoesTecnicas(questoesTecnicas);

        Page<Prova> provas = new PageImpl<>(provasList, page, provasList.size());
        Page<ProvaCorrigidaResponse> provaCorrigidaResponsePage = new PageImpl<>(provaCorrigida, page, provaCorrigida.size());

        Mockito.when(provaRepository.findAllByStatusEquals(page, StatusProva.CORRIGIDA)).thenReturn(provas);
        Mockito.when(retornarQuestaoTecnicaComRespostaResponseService.buscar(prova)).thenReturn(questoesTecnicas);
        Mockito.when(retornarQuestaoDissertativaComRespostaResponseService.buscar(prova)).thenReturn(questaoDissertativa);
        Mockito.when(retornarQuestaoMultiplaEscolhaComRespostaResponseService.buscar(prova)).thenReturn(questaoMultiplaEscolha);

        buscarProvasCorrigidasComNotaService.buscar(page);

        Mockito.verify(retornarQuestaoTecnicaComRespostaResponseService).buscar(prova);
    }

    @Test
    public void deveChamarRetornarQuestaoDissertativaComRespostaResponseServiceQuandoBuscarProvasCorrigidasComNotaServiceForChamado() {

        PageRequest page = PageRequest.of(1, 10);
        ProvaCorrigidaResponse provaResponse = new ProvaCorrigidaResponse();

        Prova prova = new Prova();
        prova.setId(1L);
        prova.setStatus(StatusProva.CORRIGIDA);

        ProvaCorrigidaResponse provaCorrigidaResponse = new ProvaCorrigidaResponse();

        List<Prova> provasList = new ArrayList<>();
        provasList.add(prova);

        List<ProvaCorrigidaResponse> provaCorrigida = new ArrayList<>();
        provaCorrigida.add(provaCorrigidaResponse);

        List<QuestaoTecnicaComRespostaResponse> questoesTecnicas = new ArrayList<>();

        List<QuestaoDissertativaComRespostaResponse> questaoDissertativa = new ArrayList<>();

        List<QuestaoMultiplaEscolhaComRespostaResponse> questaoMultiplaEscolha = new ArrayList<>();

        provaResponse.setQuestoesDissertativas(questaoDissertativa);
        provaResponse.setQuestoesMultiplaEscolha(questaoMultiplaEscolha);
        provaResponse.setQuestoesTecnicas(questoesTecnicas);

        Page<Prova> provas = new PageImpl<>(provasList, page, provasList.size());
        Page<ProvaCorrigidaResponse> provaCorrigidaResponsePage = new PageImpl<>(provaCorrigida, page, provaCorrigida.size());

        Mockito.when(provaRepository.findAllByStatusEquals(page, StatusProva.CORRIGIDA)).thenReturn(provas);
        Mockito.when(retornarQuestaoTecnicaComRespostaResponseService.buscar(prova)).thenReturn(questoesTecnicas);
        Mockito.when(retornarQuestaoDissertativaComRespostaResponseService.buscar(prova)).thenReturn(questaoDissertativa);
        Mockito.when(retornarQuestaoMultiplaEscolhaComRespostaResponseService.buscar(prova)).thenReturn(questaoMultiplaEscolha);

        buscarProvasCorrigidasComNotaService.buscar(page);

        Mockito.verify(retornarQuestaoDissertativaComRespostaResponseService).buscar(prova);
    }

    @Test
    public void deveChamarRetornarQuestaoMultiplaEscolhaComRespostaResponseServiceQuandoBuscarProvasCorrigidasComNotaServiceForChamado() {

        PageRequest page = PageRequest.of(1, 10);
        ProvaCorrigidaResponse provaResponse = new ProvaCorrigidaResponse();

        Prova prova = new Prova();
        prova.setId(1L);
        prova.setStatus(StatusProva.CORRIGIDA);

        ProvaCorrigidaResponse provaCorrigidaResponse = new ProvaCorrigidaResponse();

        List<Prova> provasList = new ArrayList<>();
        provasList.add(prova);

        List<ProvaCorrigidaResponse> provaCorrigida = new ArrayList<>();
        provaCorrigida.add(provaCorrigidaResponse);

        List<QuestaoTecnicaComRespostaResponse> questoesTecnicas = new ArrayList<>();

        List<QuestaoDissertativaComRespostaResponse> questaoDissertativa = new ArrayList<>();

        List<QuestaoMultiplaEscolhaComRespostaResponse> questaoMultiplaEscolha = new ArrayList<>();

        provaResponse.setQuestoesDissertativas(questaoDissertativa);
        provaResponse.setQuestoesMultiplaEscolha(questaoMultiplaEscolha);
        provaResponse.setQuestoesTecnicas(questoesTecnicas);

        Page<Prova> provas = new PageImpl<>(provasList, page, provasList.size());
        Page<ProvaCorrigidaResponse> provaCorrigidaResponsePage = new PageImpl<>(provaCorrigida, page, provaCorrigida.size());

        Mockito.when(provaRepository.findAllByStatusEquals(page, StatusProva.CORRIGIDA)).thenReturn(provas);
        Mockito.when(retornarQuestaoTecnicaComRespostaResponseService.buscar(prova)).thenReturn(questoesTecnicas);
        Mockito.when(retornarQuestaoDissertativaComRespostaResponseService.buscar(prova)).thenReturn(questaoDissertativa);
        Mockito.when(retornarQuestaoMultiplaEscolhaComRespostaResponseService.buscar(prova)).thenReturn(questaoMultiplaEscolha);

        buscarProvasCorrigidasComNotaService.buscar(page);

        Mockito.verify(retornarQuestaoMultiplaEscolhaComRespostaResponseService).buscar(prova);
    }




}