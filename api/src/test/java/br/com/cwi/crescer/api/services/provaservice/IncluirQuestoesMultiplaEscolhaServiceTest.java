package br.com.cwi.crescer.api.services.provaservice;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.services.questaomultiplaescolha.ListarQuestoesMultiplaEscolhaFiltradasService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class IncluirQuestoesMultiplaEscolhaServiceTest {

    @InjectMocks
    IncluirQuestoesMultiplaEscolhaService incluirQuestoesMultiplaEscolhaService;

    @Mock
    ListarQuestoesMultiplaEscolhaFiltradasService listarQuestoesMultiplaEscolhaFiltradasService;

    @Mock
    ProvaQuestaoMultiplaEscolhaRepository repository;

    @Mock
    BuscarProvaPorIdService buscarProvaPorId;

    @Test
    public void deveChamarListarQuestoesMultiplaEscolhaFiltradasServiceQuandoIncluirQuestoesMultiplaEscolhaService() {

        BuscaQuestoesRequest buscaQuestoesRequest =
                new BuscaQuestoesRequest(Especificidade.JAVASCRIPT,
                        NivelDeDificuldade.FACIL, 1);

        Prova prova = new Prova();
        ProvaQuestaoMultiplaEscolha provaQuestaoMultiplaEscolha = new ProvaQuestaoMultiplaEscolha();
        List<QuestaoMultiplaEscolha> lista = new ArrayList<>();

        Mockito.when(listarQuestoesMultiplaEscolhaFiltradasService.listar(buscaQuestoesRequest))
                .thenReturn(lista);
        Mockito.when(buscarProvaPorId.buscar(prova.getId())).thenReturn(prova);

        incluirQuestoesMultiplaEscolhaService.incluir(prova.getId(), buscaQuestoesRequest);

        Mockito.verify(listarQuestoesMultiplaEscolhaFiltradasService).listar(buscaQuestoesRequest);
    }

    @Test
    public void deveChamarBuscarProvaPorIdServiceQuandoIncluirQuestoesMultiplaEscolhaService() {

        BuscaQuestoesRequest buscaQuestoesRequest =
                new BuscaQuestoesRequest(Especificidade.JAVASCRIPT,
                        NivelDeDificuldade.FACIL, 1);

        Prova prova = new Prova();
        ProvaQuestaoMultiplaEscolha provaQuestaoMultiplaEscolha = new ProvaQuestaoMultiplaEscolha();
        List<QuestaoMultiplaEscolha> lista = new ArrayList<>();

        Mockito.when(listarQuestoesMultiplaEscolhaFiltradasService.listar(buscaQuestoesRequest))
                .thenReturn(lista);
        Mockito.when(buscarProvaPorId.buscar(prova.getId())).thenReturn(prova);

        incluirQuestoesMultiplaEscolhaService.incluir(prova.getId(), buscaQuestoesRequest);

        Mockito.verify(buscarProvaPorId).buscar(prova.getId());
    }

    @Test
    public void deveChamarProvaQuestaoMultiplaEscolhaRepositoryQuandoIncluirQuestoesMultiplaEscolhaService() {

        BuscaQuestoesRequest buscaQuestoesRequest =
                new BuscaQuestoesRequest(Especificidade.JAVASCRIPT,
                        NivelDeDificuldade.FACIL, 1);

        Prova prova = new Prova();
        ProvaQuestaoMultiplaEscolha provaQuestaoMultiplaEscolha = new ProvaQuestaoMultiplaEscolha();
        List<QuestaoMultiplaEscolha> lista = new ArrayList<>();
        QuestaoMultiplaEscolha questaoMultiplaEscolha = new QuestaoMultiplaEscolha();
        lista.add(questaoMultiplaEscolha);
        provaQuestaoMultiplaEscolha.setProva(prova);
        provaQuestaoMultiplaEscolha.setQuestao(questaoMultiplaEscolha);
        Mockito.when(listarQuestoesMultiplaEscolhaFiltradasService.listar(buscaQuestoesRequest))
                .thenReturn(lista);
        Mockito.when(buscarProvaPorId.buscar(prova.getId())).thenReturn(prova);
        Mockito.when(repository.save(provaQuestaoMultiplaEscolha)).thenReturn(provaQuestaoMultiplaEscolha);

        incluirQuestoesMultiplaEscolhaService.incluir(prova.getId(), buscaQuestoesRequest);

        Mockito.verify(repository).save(provaQuestaoMultiplaEscolha);
    }
}