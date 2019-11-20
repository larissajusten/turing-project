package br.com.cwi.crescer.api.services.questaotecnica;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
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
public class ListarQuestoesTecnicasFiltradasServiceTest {

    @InjectMocks
    ListarQuestoesTecnicasFiltradasService listarQuestoesTecnicasFiltradasService;

    @Mock
    BuscarQuestoesTecnicasFiltradasService buscarQuestoesTecnicasFiltradasService;
    @Mock
    QuestaoValidator validator;

    @Test
    public void deveBuscarQuestoesDeMultiplaEscolhaConformeParametros() {

        BuscaQuestoesRequest buscaQuestoesRequest =
                new BuscaQuestoesRequest(Especificidade.JAVA, NivelDeDificuldade.DIFICIL, 1);

        List<QuestaoTecnica> lista = new ArrayList<>();
        List<QuestaoTecnica> listaQueAtendeRequisitos = new ArrayList<>();
        listaQueAtendeRequisitos.add(new QuestaoTecnica());
        Mockito.when(buscarQuestoesTecnicasFiltradasService.buscar(buscaQuestoesRequest.getEspecificidade(), buscaQuestoesRequest.getNivelDeDificuldade())).thenReturn(listaQueAtendeRequisitos);

        listarQuestoesTecnicasFiltradasService.listar(buscaQuestoesRequest);

        Assert.assertEquals(listarQuestoesTecnicasFiltradasService.listar(buscaQuestoesRequest), listaQueAtendeRequisitos);
    }

    @Test
    public void deveChamarQuestaoValidatorQuandoListarQuestoesTecnicasFiltradasServiceForChamado() {

        BuscaQuestoesRequest buscaQuestoesRequest =
                new BuscaQuestoesRequest(Especificidade.JAVA, NivelDeDificuldade.DIFICIL, 1);

        List<QuestaoTecnica> listaQueAtendeRequisitos = new ArrayList<>();
        listaQueAtendeRequisitos.add(new QuestaoTecnica());
        Mockito.when(buscarQuestoesTecnicasFiltradasService.buscar(buscaQuestoesRequest.getEspecificidade(), buscaQuestoesRequest.getNivelDeDificuldade())).thenReturn(listaQueAtendeRequisitos);

        listarQuestoesTecnicasFiltradasService.listar(buscaQuestoesRequest);

        Mockito.verify(validator).validar(listaQueAtendeRequisitos.size(), buscaQuestoesRequest.getQuantidadeDeQuestoes());
    }

}
