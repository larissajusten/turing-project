package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.ProvaCorrigidaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoDissertativaComRespostaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaComRespostaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoTecnicaComRespostaResponse;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import br.com.cwi.crescer.api.validator.ProvasVaziaValidador;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

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

    @Mock
    private ProvasVaziaValidador validator;


    @Test
    public void deveChamarProvaRepositoryQuandoBuscarProvasCorrigidasComNotaServiceForChamado() {

        ProvaCorrigidaResponse provaResponse = new ProvaCorrigidaResponse();

        Prova prova = new Prova();
        prova.setId(1L);
        prova.setStatus(StatusProva.CORRIGIDA);

        List<Prova> provasList = new ArrayList<>();
        provasList.add(prova);

        List<QuestaoTecnicaComRespostaResponse> questoesTecnicas = new ArrayList<>();

        List<QuestaoDissertativaComRespostaResponse> questaoDissertativa = new ArrayList<>();

        List<QuestaoMultiplaEscolhaComRespostaResponse> questaoMultiplaEscolha = new ArrayList<>();

        provaResponse.setQuestoesDissertativas(questaoDissertativa);
        provaResponse.setQuestoesMultiplaEscolha(questaoMultiplaEscolha);
        provaResponse.setQuestoesTecnicas(questoesTecnicas);

        List<Prova> provas = new ArrayList<>();

        Mockito.when(provaRepository.findPorNomeUsuarioCorrigida("Va", StatusProva.CORRIGIDA)).thenReturn(provas);

        buscarProvasCorrigidasComNotaService.buscar("Va");

        Mockito.verify(provaRepository).findPorNomeUsuarioCorrigida("Va", StatusProva.CORRIGIDA);
    }

    @Test
    public void deveChamarRetornarQuestaoTecnicaComRespostaResponseServiceQuandoBuscarProvasCorrigidasComNotaServiceForChamado() {

        ProvaCorrigidaResponse provaResponse = new ProvaCorrigidaResponse();

        Prova prova = new Prova();
        prova.setId(1L);
        prova.setStatus(StatusProva.CORRIGIDA);

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        prova.setCriador(usuario);

        List<Prova> provasList = new ArrayList<>();
        provasList.add(prova);

        List<QuestaoTecnicaComRespostaResponse> questoesTecnicas = new ArrayList<>();

        List<QuestaoDissertativaComRespostaResponse> questaoDissertativa = new ArrayList<>();

        List<QuestaoMultiplaEscolhaComRespostaResponse> questaoMultiplaEscolha = new ArrayList<>();

        provaResponse.setQuestoesDissertativas(questaoDissertativa);
        provaResponse.setQuestoesMultiplaEscolha(questaoMultiplaEscolha);
        provaResponse.setQuestoesTecnicas(questoesTecnicas);

        Mockito.when(provaRepository.findPorNomeUsuarioCorrigida("Va", StatusProva.CORRIGIDA)).thenReturn(provasList);
        Mockito.when(retornarQuestaoTecnicaComRespostaResponseService.buscar(prova)).thenReturn(questoesTecnicas);
        Mockito.when(retornarQuestaoDissertativaComRespostaResponseService.buscar(prova)).thenReturn(questaoDissertativa);
        Mockito.when(retornarQuestaoMultiplaEscolhaComRespostaResponseService.buscar(prova)).thenReturn(questaoMultiplaEscolha);

        buscarProvasCorrigidasComNotaService.buscar("Va");

        Mockito.verify(retornarQuestaoTecnicaComRespostaResponseService).buscar(prova);
    }

    @Test
    public void deveChamarRetornarQuestaoDissertativaComRespostaResponseServiceQuandoBuscarProvasCorrigidasComNotaServiceForChamado() {

        ProvaCorrigidaResponse provaResponse = new ProvaCorrigidaResponse();
        Usuario usuario = new Usuario();
        Prova prova = new Prova();
        prova.setId(1L);
        prova.setStatus(StatusProva.CORRIGIDA);
        prova.setCriador(usuario);

        List<Prova> provasList = new ArrayList<>();
        provasList.add(prova);

        List<QuestaoTecnicaComRespostaResponse> questoesTecnicas = new ArrayList<>();

        List<QuestaoDissertativaComRespostaResponse> questaoDissertativa = new ArrayList<>();

        List<QuestaoMultiplaEscolhaComRespostaResponse> questaoMultiplaEscolha = new ArrayList<>();

        provaResponse.setQuestoesDissertativas(questaoDissertativa);
        provaResponse.setQuestoesMultiplaEscolha(questaoMultiplaEscolha);
        provaResponse.setQuestoesTecnicas(questoesTecnicas);

        Mockito.when(provaRepository.findPorNomeUsuarioCorrigida("Va", StatusProva.CORRIGIDA)).thenReturn(provasList);
        Mockito.when(retornarQuestaoTecnicaComRespostaResponseService.buscar(prova)).thenReturn(questoesTecnicas);
        Mockito.when(retornarQuestaoDissertativaComRespostaResponseService.buscar(prova)).thenReturn(questaoDissertativa);
        Mockito.when(retornarQuestaoMultiplaEscolhaComRespostaResponseService.buscar(prova)).thenReturn(questaoMultiplaEscolha);

        buscarProvasCorrigidasComNotaService.buscar("Va");

        Mockito.verify(retornarQuestaoDissertativaComRespostaResponseService).buscar(prova);
    }

    @Test
    public void deveChamarRetornarQuestaoMultiplaEscolhaComRespostaResponseServiceQuandoBuscarProvasCorrigidasComNotaServiceForChamado() {

        ProvaCorrigidaResponse provaResponse = new ProvaCorrigidaResponse();

        Prova prova = new Prova();
        prova.setId(1L);
        prova.setStatus(StatusProva.CORRIGIDA);

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        prova.setCriador(usuario);

        List<Prova> provasList = new ArrayList<>();
        provasList.add(prova);

        List<QuestaoTecnicaComRespostaResponse> questoesTecnicas = new ArrayList<>();

        List<QuestaoDissertativaComRespostaResponse> questaoDissertativa = new ArrayList<>();

        List<QuestaoMultiplaEscolhaComRespostaResponse> questaoMultiplaEscolha = new ArrayList<>();

        provaResponse.setQuestoesDissertativas(questaoDissertativa);
        provaResponse.setQuestoesMultiplaEscolha(questaoMultiplaEscolha);
        provaResponse.setQuestoesTecnicas(questoesTecnicas);

        Mockito.when(provaRepository.findPorNomeUsuarioCorrigida("Va", StatusProva.CORRIGIDA)).thenReturn(provasList);
        Mockito.when(retornarQuestaoTecnicaComRespostaResponseService.buscar(prova)).thenReturn(questoesTecnicas);
        Mockito.when(retornarQuestaoDissertativaComRespostaResponseService.buscar(prova)).thenReturn(questaoDissertativa);
        Mockito.when(retornarQuestaoMultiplaEscolhaComRespostaResponseService.buscar(prova)).thenReturn(questaoMultiplaEscolha);

        buscarProvasCorrigidasComNotaService.buscar("Va");

        Mockito.verify(retornarQuestaoMultiplaEscolhaComRespostaResponseService).buscar(prova);
    }




}
