package br.com.cwi.crescer.api.services.questaotecnica;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ListarTodasQuestoesTecnicasFiltradasServiceTest {

    @InjectMocks
    ListarTodasQuestoesTecnicasFiltradasService listarTodasQuestoesTecnicasFiltradasService;

    @Mock
    BuscarQuestoesTecnicasFiltradasService buscarQuestoesTecnicasFiltradasService;

    @Test
    public void chamar() {

        BuscaQuestoesRequest buscaQuestoesRequest =
                new BuscaQuestoesRequest(Especificidade.JAVASCRIPT,
                        NivelDeDificuldade.FACIL, 1);

        List<QuestaoTecnica> questoes = new ArrayList<>();

        Mockito.when(buscarQuestoesTecnicasFiltradasService.buscar(
                buscaQuestoesRequest.getEspecificidade(), buscaQuestoesRequest.getNivelDeDificuldade()))
                .thenReturn(questoes);

        listarTodasQuestoesTecnicasFiltradasService.buscar(buscaQuestoesRequest);

        Mockito.verify(buscarQuestoesTecnicasFiltradasService)
                .buscar(buscaQuestoesRequest.getEspecificidade(),
                        buscaQuestoesRequest.getNivelDeDificuldade());

    }
}