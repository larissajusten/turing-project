package br.com.cwi.crescer.api.services.questaodissertativa;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.exception.questoes.QuestaoNaoEncontradaException;
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
public class ListarQuestoesDissertativasFiltradasServiceTest {

    private static final int VALOR_ESPERADO_DE_RETORNO_DO_SIZE_DA_LISTA_DE_FILTRADAS = 1;

    @InjectMocks
    ListarQuestoesDissertativasFiltradasService listarQuestoesDissertativasFiltradasService;

    @Mock
    BuscarQuestaoDissertativaPorEspecificidadeENivelService buscarQuestaoDissertativaPorEspecificidadeENivelService;

    @Test
    public void deveRetornarUmaListaComOTamanhoDoNumeroDeQuestoesQueForamSolicitadasQuandoListarQuestoesDissertativasFiltradasServiceForChamada() {


        BuscaQuestoesRequest buscaQuestoesRequest =
                new BuscaQuestoesRequest(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 1);

        List<QuestaoDissertativa> lista = new ArrayList<>();
        List<QuestaoDissertativa> listaQueAtendeRequisitos = new ArrayList<>();
        listaQueAtendeRequisitos.add(new QuestaoDissertativa());

        Mockito.when(buscarQuestaoDissertativaPorEspecificidadeENivelService
                .buscar(buscaQuestoesRequest.getEspecificidade(),
                        buscaQuestoesRequest.getNivelDeDificuldade()))
                .thenReturn(listaQueAtendeRequisitos);

        listarQuestoesDissertativasFiltradasService.listar(buscaQuestoesRequest);

        Assert.assertEquals(listarQuestoesDissertativasFiltradasService.listar(buscaQuestoesRequest).size(), VALOR_ESPERADO_DE_RETORNO_DO_SIZE_DA_LISTA_DE_FILTRADAS);
    }

    @Test
    public void deveChamarBuscarQuestaoDissertativaPorEspecificidadeENivelServiceQuandoListarQuestoesDissertativasFiltradasServiceForChamada() {

        BuscaQuestoesRequest buscaQuestoesRequest =
                new BuscaQuestoesRequest(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 1);

        List<QuestaoDissertativa> lista = new ArrayList<>();
        List<QuestaoDissertativa> listaQueAtendeRequisitos = new ArrayList<>();
        listaQueAtendeRequisitos.add(new QuestaoDissertativa());

        Mockito.when(buscarQuestaoDissertativaPorEspecificidadeENivelService
                .buscar(buscaQuestoesRequest.getEspecificidade(),
                        buscaQuestoesRequest.getNivelDeDificuldade()))
                .thenReturn(listaQueAtendeRequisitos);

        listarQuestoesDissertativasFiltradasService.listar(buscaQuestoesRequest);

        Mockito.verify(buscarQuestaoDissertativaPorEspecificidadeENivelService).buscar(buscaQuestoesRequest.getEspecificidade(),
                buscaQuestoesRequest.getNivelDeDificuldade());
    }

    @Test(expected = QuestaoNaoEncontradaException.class)
    public void deveLancarUmaExceptionQuandoListarQuestoesDissertativasFiltradasServiceForChamadaENaoEncontrarNenhumaQuestao() {

        BuscaQuestoesRequest buscaQuestoesRequest =
                new BuscaQuestoesRequest(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 1);

        List<QuestaoDissertativa> lista = new ArrayList<>();
        List<QuestaoDissertativa> listaQueAtendeRequisitos = new ArrayList<>();


        Mockito.when(buscarQuestaoDissertativaPorEspecificidadeENivelService
                .buscar(buscaQuestoesRequest.getEspecificidade(),
                        buscaQuestoesRequest.getNivelDeDificuldade()))
                .thenReturn(listaQueAtendeRequisitos);

        listarQuestoesDissertativasFiltradasService.listar(buscaQuestoesRequest);
    }



}