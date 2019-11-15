package br.com.cwi.crescer.api.services.questaodissertativa;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
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
public class ListarTodasQuestoesDissertativasFiltradasServiceTest {

    @InjectMocks
    ListarTodasQuestoesDissertativasFiltradasService listarQuestoesDissertativasFiltradasService;

    @Mock
    BuscarQuestaoDissertativaPorEspecificidadeENivelService buscarQuestaoDissertativaPorEspecificidadeENivelService;

    @Test
    public void deveChamarBuscarQuestaoDissertativaPorEspecificidadeENivelServiceQuandoListarQuestoesDissertativasFiltradasServiceForChamada() {
        BuscaQuestoesRequest buscaQuestoesRequest = new BuscaQuestoesRequest(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 1);
        QuestaoDissertativa questao = new QuestaoDissertativa();
        questao.setNivelDeDificuldade(NivelDeDificuldade.FACIL);
        questao.setEspecificidade(Especificidade.JAVASCRIPT);
        List<QuestaoDissertativa> questoes = new ArrayList<>();
        questoes.add(questao);
        Mockito.when(buscarQuestaoDissertativaPorEspecificidadeENivelService
                .buscar(buscaQuestoesRequest.getEspecificidade(), buscaQuestoesRequest.getNivelDeDificuldade())).thenReturn(questoes);

        listarQuestoesDissertativasFiltradasService.listar(buscaQuestoesRequest);

        Mockito.verify(buscarQuestaoDissertativaPorEspecificidadeENivelService).buscar(buscaQuestoesRequest.getEspecificidade(), buscaQuestoesRequest.getNivelDeDificuldade());
    }

    @Test
    public void deveRetornarUmaListaDeQuestoesPorEspecificidadeENivelServiceQuandoListarQuestoesDissertativasFiltradasServiceForChamada() {
        BuscaQuestoesRequest buscaQuestoesRequest = new BuscaQuestoesRequest(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 1);
        QuestaoDissertativa questao = new QuestaoDissertativa();
        questao.setNivelDeDificuldade(NivelDeDificuldade.FACIL);
        questao.setEspecificidade(Especificidade.JAVASCRIPT);
        List<QuestaoDissertativa> questoes = new ArrayList<>();
        questoes.add(questao);
        Mockito.when(buscarQuestaoDissertativaPorEspecificidadeENivelService
                .buscar(buscaQuestoesRequest.getEspecificidade(), buscaQuestoesRequest.getNivelDeDificuldade())).thenReturn(questoes);

        listarQuestoesDissertativasFiltradasService.listar(buscaQuestoesRequest);

        Assert.assertEquals(listarQuestoesDissertativasFiltradasService
                .listar(buscaQuestoesRequest).size(),
                questoes.size());
    }
}