package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.validator.QuestaoValidator;
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
public class ListarQuestoesMultiplaEscolhaFiltradasServiceTest {

    @InjectMocks
    ListarQuestoesMultiplaEscolhaFiltradasService listarQuestoesMultiplaEscolhaFiltradasService;

    @Mock
    BuscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeService buscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeService;

    @Mock
    QuestaoValidator validator;

    @Test
    public void deveChamarBuscarQuestoesMultiplaEscolhaFiltradasServiceQuandoListarQuestoesMultiplaEscolhaFiltradasServiceForChamado() {
        BuscaQuestoesRequest buscaQuestoesRequest =
                new BuscaQuestoesRequest(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 1);
        List<QuestaoMultiplaEscolha> lista = new ArrayList<>();
        lista.add(new QuestaoMultiplaEscolha());

        Mockito.when(buscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeService.buscar(
                buscaQuestoesRequest.getEspecificidade(), buscaQuestoesRequest.getNivelDeDificuldade(), buscaQuestoesRequest.getQuantidadeDeQuestoes())).thenReturn(lista);

        listarQuestoesMultiplaEscolhaFiltradasService.listar(buscaQuestoesRequest);

        Mockito.verify(buscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeService).buscar(
                buscaQuestoesRequest.getEspecificidade(), buscaQuestoesRequest.getNivelDeDificuldade(), buscaQuestoesRequest.getQuantidadeDeQuestoes());
    }

    @Test
    public void deveRetornarUmaListaDeQuestaoMultiplaEscolhaQuandoListarQuestoesMultiplaEscolhaFiltradasServiceForChamdo() {
        BuscaQuestoesRequest buscaQuestoesRequest =
                new BuscaQuestoesRequest(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 1);
        List<QuestaoMultiplaEscolha> lista = new ArrayList<>();
        lista.add(new QuestaoMultiplaEscolha());

        Mockito.when(buscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeService.buscar(
                buscaQuestoesRequest.getEspecificidade(), buscaQuestoesRequest.getNivelDeDificuldade(), buscaQuestoesRequest.getQuantidadeDeQuestoes())).thenReturn(lista);

        listarQuestoesMultiplaEscolhaFiltradasService.listar(buscaQuestoesRequest);

        Assert.assertEquals(listarQuestoesMultiplaEscolhaFiltradasService.listar(buscaQuestoesRequest), lista);
    }

}