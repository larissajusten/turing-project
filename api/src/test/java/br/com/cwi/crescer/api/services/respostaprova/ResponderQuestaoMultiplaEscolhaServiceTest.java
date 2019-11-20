package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.domain.resposta.RespostasMultiplaEscolhaProva;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.repository.resposta.RespostaMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.services.alternativamultiplaescolha.BuscarAlternativaMultiplaEscolhaPorIdService;
import br.com.cwi.crescer.api.services.prova.BuscarProvaPorIdService;
import br.com.cwi.crescer.api.services.questaomultiplaescolha.BuscarQuestaoMultiplaEscolhaPorIdService;
import br.com.cwi.crescer.api.services.usuario.BuscarUsuarioPorIdService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ResponderQuestaoMultiplaEscolhaServiceTest {

    @InjectMocks
    ResponderQuestaoMultiplaEscolhaService responderQuestaoMultiplaEscolhaService;

    @Mock
    RespostaMultiplaEscolhaRepository repository;

    @Mock
    BuscarProvaPorIdService buscarProvaPorIdService;

    @Mock
    BuscarQuestaoMultiplaEscolhaPorIdService buscarQuestaoMultiplaEscolhaPorIdService;

    @Mock
    BuscarAlternativaMultiplaEscolhaPorIdService buscarAlternativaMultiplaEscolhaPorIdService;

    @Mock
    private BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Test
    public void deveChamarBuscarAlternativaMultiplaEscolhaPorIdServiceQuandoResponderQuestaoMultiplaEscolhaServiceForChamado() {

        RespostasMultiplaEscolhaProva respostasMultiplaEscolhaProva = new RespostasMultiplaEscolhaProva();
        AlternativaMultiplaEscolha alternativaMultiplaEscolha = new AlternativaMultiplaEscolha();
        respostasMultiplaEscolhaProva.setAlternativaMultiplaEscolha(alternativaMultiplaEscolha);
        Prova prova = new Prova();
        respostasMultiplaEscolhaProva.setProva(prova);
        QuestaoMultiplaEscolha questaoMultiplaEscolha = new QuestaoMultiplaEscolha();
        respostasMultiplaEscolhaProva.setQuestaoMultiplaEscolha(questaoMultiplaEscolha);

        Usuario usuario = new Usuario();
        Mockito.when(buscarUsuarioPorIdService.buscar(1L)).thenReturn(usuario);

        respostasMultiplaEscolhaProva.setUsuario(usuario);
        Mockito.when(buscarAlternativaMultiplaEscolhaPorIdService.buscar(alternativaMultiplaEscolha.getId())).thenReturn(alternativaMultiplaEscolha);

        Mockito.when(buscarQuestaoMultiplaEscolhaPorIdService.buscar(questaoMultiplaEscolha.getId())).thenReturn(questaoMultiplaEscolha);

        responderQuestaoMultiplaEscolhaService.responder(prova, questaoMultiplaEscolha.getId(), alternativaMultiplaEscolha.getId());

        Mockito.verify(buscarAlternativaMultiplaEscolhaPorIdService).buscar(alternativaMultiplaEscolha.getId());
    }


    @Test
    public void deveChamarBuscarQuestaoMultiplaEscolhaPorIdServiceQuandoResponderQuestaoMultiplaEscolhaServiceForChamado() {

        RespostasMultiplaEscolhaProva respostasMultiplaEscolhaProva = new RespostasMultiplaEscolhaProva();
        AlternativaMultiplaEscolha alternativaMultiplaEscolha = new AlternativaMultiplaEscolha();
        respostasMultiplaEscolhaProva.setAlternativaMultiplaEscolha(alternativaMultiplaEscolha);
        Prova prova = new Prova();
        respostasMultiplaEscolhaProva.setProva(prova);
        QuestaoMultiplaEscolha questaoMultiplaEscolha = new QuestaoMultiplaEscolha();
        respostasMultiplaEscolhaProva.setQuestaoMultiplaEscolha(questaoMultiplaEscolha);

        Usuario usuario = new Usuario();
        Mockito.when(buscarUsuarioPorIdService.buscar(1L)).thenReturn(usuario);

        respostasMultiplaEscolhaProva.setUsuario(usuario);
        Mockito.when(buscarAlternativaMultiplaEscolhaPorIdService.buscar(alternativaMultiplaEscolha.getId())).thenReturn(alternativaMultiplaEscolha);

        Mockito.when(buscarQuestaoMultiplaEscolhaPorIdService.buscar(questaoMultiplaEscolha.getId())).thenReturn(questaoMultiplaEscolha);

        responderQuestaoMultiplaEscolhaService.responder(prova, questaoMultiplaEscolha.getId(), alternativaMultiplaEscolha.getId());

        Mockito.verify(buscarQuestaoMultiplaEscolhaPorIdService).buscar(questaoMultiplaEscolha.getId());
    }

    @Test
    public void deveChamarRespostaMultiplaEscolhaRepositoryQuandoResponderQuestaoMultiplaEscolhaServiceForChamado() {

        RespostasMultiplaEscolhaProva respostasMultiplaEscolhaProva = new RespostasMultiplaEscolhaProva();
        AlternativaMultiplaEscolha alternativaMultiplaEscolha = new AlternativaMultiplaEscolha();
        respostasMultiplaEscolhaProva.setAlternativaMultiplaEscolha(alternativaMultiplaEscolha);
        Prova prova = new Prova();
        respostasMultiplaEscolhaProva.setProva(prova);
        QuestaoMultiplaEscolha questaoMultiplaEscolha = new QuestaoMultiplaEscolha();
        respostasMultiplaEscolhaProva.setQuestaoMultiplaEscolha(questaoMultiplaEscolha);

        Usuario usuario = new Usuario();
        Mockito.when(buscarUsuarioPorIdService.buscar(1L)).thenReturn(usuario);

        respostasMultiplaEscolhaProva.setUsuario(usuario);
        Mockito.when(buscarAlternativaMultiplaEscolhaPorIdService.buscar(alternativaMultiplaEscolha.getId())).thenReturn(alternativaMultiplaEscolha);

        Mockito.when(buscarQuestaoMultiplaEscolhaPorIdService.buscar(questaoMultiplaEscolha.getId())).thenReturn(questaoMultiplaEscolha);

        responderQuestaoMultiplaEscolhaService.responder(prova, questaoMultiplaEscolha.getId(), alternativaMultiplaEscolha.getId());

        Mockito.verify(repository).save(respostasMultiplaEscolhaProva);
    }

    @Test
    public void deveRetornarRespostasMultiplaEscolhaProvaQuandoResponderQuestaoMultiplaEscolhaServiceForChamado() {

        RespostasMultiplaEscolhaProva respostasMultiplaEscolhaProva = new RespostasMultiplaEscolhaProva();
        AlternativaMultiplaEscolha alternativaMultiplaEscolha = new AlternativaMultiplaEscolha();
        respostasMultiplaEscolhaProva.setAlternativaMultiplaEscolha(alternativaMultiplaEscolha);
        Prova prova = new Prova();
        respostasMultiplaEscolhaProva.setProva(prova);
        QuestaoMultiplaEscolha questaoMultiplaEscolha = new QuestaoMultiplaEscolha();
        respostasMultiplaEscolhaProva.setQuestaoMultiplaEscolha(questaoMultiplaEscolha);

        Usuario usuario = new Usuario();
        Mockito.when(buscarUsuarioPorIdService.buscar(1L)).thenReturn(usuario);

        respostasMultiplaEscolhaProva.setUsuario(usuario);
        Mockito.when(buscarAlternativaMultiplaEscolhaPorIdService.buscar(alternativaMultiplaEscolha.getId())).thenReturn(alternativaMultiplaEscolha);

        Mockito.when(buscarQuestaoMultiplaEscolhaPorIdService.buscar(questaoMultiplaEscolha.getId())).thenReturn(questaoMultiplaEscolha);
        Mockito.when(repository.save(respostasMultiplaEscolhaProva)).thenReturn(respostasMultiplaEscolhaProva);

        responderQuestaoMultiplaEscolhaService.responder(prova, questaoMultiplaEscolha.getId(), alternativaMultiplaEscolha.getId());

        Assert.assertEquals(responderQuestaoMultiplaEscolhaService.responder(prova,
                questaoMultiplaEscolha.getId(), alternativaMultiplaEscolha.getId()), respostasMultiplaEscolhaProva);
    }


}