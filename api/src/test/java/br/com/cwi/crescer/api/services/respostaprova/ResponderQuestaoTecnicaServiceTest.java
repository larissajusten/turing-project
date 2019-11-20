package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.domain.resposta.RespostasTecnicaProva;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.repository.resposta.RespostasTecnicaRepository;
import br.com.cwi.crescer.api.services.prova.BuscarProvaPorIdService;
import br.com.cwi.crescer.api.services.questaotecnica.BuscarQuestaoTecnicaPorIdService;
import br.com.cwi.crescer.api.services.usuario.BuscarUsuarioPorIdService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ResponderQuestaoTecnicaServiceTest {

    @InjectMocks
    ResponderQuestaoTecnicaService responderQuestaoTecnicaService;

    @Mock
    RespostasTecnicaRepository repository;

    @Mock
    BuscarProvaPorIdService buscarProvaPorIdService;

    @Mock
    BuscarQuestaoTecnicaPorIdService buscarQuestaoTecnicaPorIdService;

    @Mock
    private BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Test
    public void deveChamarBuscarQuestaoTecnicaPorIdServiceQuandoResponderQuestaoTecnicaServiceForChamado() {
        String resposta = "resposta";
        RespostasTecnicaProva respostasTecnicaProva = new RespostasTecnicaProva();
        respostasTecnicaProva.setResposta(resposta);
        Prova prova = new Prova();
        respostasTecnicaProva.setProva(prova);
        QuestaoTecnica questaoTecnica = new QuestaoTecnica();
        respostasTecnicaProva.setQuestaoTecnica(questaoTecnica);

        Usuario usuario = new Usuario();
        Mockito.when(buscarUsuarioPorIdService.buscar(1L)).thenReturn(usuario);
        respostasTecnicaProva.setUsuario(usuario);


        Mockito.when(buscarQuestaoTecnicaPorIdService.buscar(questaoTecnica.getId())).thenReturn(questaoTecnica);

        responderQuestaoTecnicaService.responder(prova, questaoTecnica.getId(), resposta);

        Mockito.verify(buscarQuestaoTecnicaPorIdService).buscar(questaoTecnica.getId());

    }

    @Test
    public void deveChamarRespostasTecnicaRepositoryQuandoResponderQuestaoTecnicaServiceForChamado() {
        String resposta = "resposta";
        RespostasTecnicaProva respostasTecnicaProva = new RespostasTecnicaProva();
        respostasTecnicaProva.setResposta(resposta);
        Prova prova = new Prova();
        respostasTecnicaProva.setProva(prova);
        QuestaoTecnica questaoTecnica = new QuestaoTecnica();
        respostasTecnicaProva.setQuestaoTecnica(questaoTecnica);

        Usuario usuario = new Usuario();
        Mockito.when(buscarUsuarioPorIdService.buscar(1L)).thenReturn(usuario);
        respostasTecnicaProva.setUsuario(usuario);


        Mockito.when(buscarQuestaoTecnicaPorIdService.buscar(questaoTecnica.getId())).thenReturn(questaoTecnica);

        responderQuestaoTecnicaService.responder(prova, questaoTecnica.getId(), resposta);

        buscarQuestaoTecnicaPorIdService.buscar(null);
        Mockito.verify(repository).save(respostasTecnicaProva);

    }

    @Test
    public void deveRetornarRespostasTecnicaQuandoResponderQuestaoTecnicaServiceForChamado() {
        String resposta = "resposta";
        RespostasTecnicaProva respostasTecnicaProva = new RespostasTecnicaProva();
        respostasTecnicaProva.setResposta(resposta);
        Prova prova = new Prova();
        respostasTecnicaProva.setProva(prova);
        QuestaoTecnica questaoTecnica = new QuestaoTecnica();
        respostasTecnicaProva.setQuestaoTecnica(questaoTecnica);

        Usuario usuario = new Usuario();
        Mockito.when(buscarUsuarioPorIdService.buscar(1L)).thenReturn(usuario);

        respostasTecnicaProva.setUsuario(usuario);

       
        Mockito.when(buscarQuestaoTecnicaPorIdService.buscar(questaoTecnica.getId())).thenReturn(questaoTecnica);
        Mockito.when(repository.save(respostasTecnicaProva)).thenReturn(respostasTecnicaProva);
        responderQuestaoTecnicaService.responder(prova, questaoTecnica.getId(), resposta);

        Assert.assertEquals(responderQuestaoTecnicaService.responder(prova, questaoTecnica.getId(), resposta), respostasTecnicaProva);

    }
}