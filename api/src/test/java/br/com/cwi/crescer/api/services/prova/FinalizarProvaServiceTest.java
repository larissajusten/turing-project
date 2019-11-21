package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.requests.prova.ProvaRespondidaRequest;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.enums.TipoDeQuestao;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.services.respostaprova.ResponderQuestaoDissertativaService;
import br.com.cwi.crescer.api.services.respostaprova.ResponderQuestaoMultiplaEscolhaService;
import br.com.cwi.crescer.api.services.respostaprova.ResponderQuestaoTecnicaService;
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
public class FinalizarProvaServiceTest {

    @InjectMocks
    FinalizarProvaService finalizarProvaService;

    @Mock
    FinalizarTempoDaProvaService finalizarTempoDaProvaService;

    @Mock
    BuscarProvaPorIdService buscarProvaPorIdService;

    @Mock
    ResponderQuestaoDissertativaService responderQuestaoDissertativaService;

    @Mock
    ResponderQuestaoTecnicaService responderQuestaoTecnicaService;

    @Mock
    ResponderQuestaoMultiplaEscolhaService responderQuestaoMultiplaEscolhaService;

    @Test
    public void deveChamarResponderQuestaoDissertativaServiceQuandoFinalizarProvaServiceForChamado() {
        List<ProvaRespondidaRequest> request = new ArrayList<>();
        Prova prova = new Prova();
        ProvaRespondidaRequest provaRespondidaRequest = new ProvaRespondidaRequest();
        QuestaoDissertativa questaoDissertativa = new QuestaoDissertativa();

        provaRespondidaRequest.setIdQuestao(questaoDissertativa.getId());
        provaRespondidaRequest.setTipoDeQuestao(TipoDeQuestao.DISSERTATIVA);
        provaRespondidaRequest.setResposta("Teste");

        request.add(provaRespondidaRequest);

        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);

        finalizarProvaService.finalizar(prova.getId(), request);

        Mockito.verify(responderQuestaoDissertativaService)
                .responder(prova, provaRespondidaRequest.getIdQuestao(), provaRespondidaRequest.getResposta());

    }


    @Test
    public void deveChamarResponderQuestaoMultiplaEscolhaServiceQuandoFinalizarProvaServiceForChamado() {
        List<ProvaRespondidaRequest> request = new ArrayList<>();
        Prova prova = new Prova();
        ProvaRespondidaRequest provaRespondidaRequest = new ProvaRespondidaRequest();
        QuestaoMultiplaEscolha questaoMultiplaEscolha = new QuestaoMultiplaEscolha();

        provaRespondidaRequest.setIdQuestao(questaoMultiplaEscolha.getId());
        provaRespondidaRequest.setTipoDeQuestao(TipoDeQuestao.MULTIPLA);
        provaRespondidaRequest.setResposta("1");

        request.add(provaRespondidaRequest);

        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);

        finalizarProvaService.finalizar(prova.getId(), request);

        Mockito.verify(responderQuestaoMultiplaEscolhaService)
                .responder(prova, provaRespondidaRequest.getIdQuestao(), Long.valueOf(provaRespondidaRequest.getResposta()));

    }

    @Test
    public void deveChamarResponderQuestaoTecnicaServiceQuandoFinalizarProvaServiceForChamado() {
        List<ProvaRespondidaRequest> request = new ArrayList<>();
        Prova prova = new Prova();
        ProvaRespondidaRequest provaRespondidaRequest = new ProvaRespondidaRequest();
        QuestaoTecnica questaoTecnica = new QuestaoTecnica();

        provaRespondidaRequest.setIdQuestao(questaoTecnica.getId());
        provaRespondidaRequest.setTipoDeQuestao(TipoDeQuestao.TECNICA);
        provaRespondidaRequest.setResposta("Teste");

        request.add(provaRespondidaRequest);

        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);

        finalizarProvaService.finalizar(prova.getId(), request);

        Mockito.verify(responderQuestaoTecnicaService)
                .responder(prova, provaRespondidaRequest.getIdQuestao(), provaRespondidaRequest.getResposta());

    }

    @Test
    public void deveChamarFinalizarTempoDaProvaServiceQuandoFinalizarProvaServiceForChamado() {
        List<ProvaRespondidaRequest> request = new ArrayList<>();
        Prova prova = new Prova();
        ProvaRespondidaRequest provaRespondidaRequest = new ProvaRespondidaRequest();
        QuestaoTecnica questaoTecnica = new QuestaoTecnica();

        provaRespondidaRequest.setIdQuestao(questaoTecnica.getId());
        provaRespondidaRequest.setTipoDeQuestao(TipoDeQuestao.TECNICA);
        provaRespondidaRequest.setResposta("Teste");

        request.add(provaRespondidaRequest);

        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);

        finalizarProvaService.finalizar(prova.getId(), request);

        Mockito.verify(finalizarTempoDaProvaService).finalizar(prova.getId());

    }

    @Test
    public void deveRetornarStatusProvaQuandoFinalizarProvaServiceForChamado() {
        List<ProvaRespondidaRequest> request = new ArrayList<>();
        Prova prova = new Prova();

        ProvaRespondidaRequest provaRespondidaRequest = new ProvaRespondidaRequest();
        QuestaoTecnica questaoTecnica = new QuestaoTecnica();

        provaRespondidaRequest.setIdQuestao(questaoTecnica.getId());
        provaRespondidaRequest.setTipoDeQuestao(TipoDeQuestao.TECNICA);
        provaRespondidaRequest.setResposta("Teste");

        request.add(provaRespondidaRequest);

        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);
        Mockito.when(finalizarTempoDaProvaService.finalizar(prova.getId())).thenReturn(StatusProva.AGUARDANDO_CORRECAO);
        finalizarProvaService.finalizar(prova.getId(), request);

        Assert.assertEquals(StatusProva.AGUARDANDO_CORRECAO, finalizarProvaService.finalizar(prova.getId(), request));

    }
}