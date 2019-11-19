package br.com.cwi.crescer.api.services.questaodissertativa;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.exception.questoes.QuestaoNaoEncontradaException;
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
public class ListarQuestoesDissertativasFiltradasServiceTest {

    private static final int VALOR_ESPERADO_DE_RETORNO_DO_SIZE_DA_LISTA_DE_FILTRADAS = 1;

    @InjectMocks
    ListarQuestoesDissertativasFiltradasService listarQuestoesDissertativasFiltradasService;

    @Mock
    BuscarQuestaoDissertativaPorEspecificidadeENivelService buscarQuestaoDissertativaPorEspecificidadeENivelService;

    @Mock
    QuestaoValidator validator;
    @Test
    public void deveRetornarUmaListaComOTamanhoDoNumeroDeQuestoesQueForamSolicitadasQuandoListarQuestoesDissertativasFiltradasServiceForChamada() {

        BuscaQuestoesRequest buscaQuestoesRequest =
                new BuscaQuestoesRequest(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 1);

        List<QuestaoDissertativa> listaQueAtendeRequisitos = new ArrayList<>();
        listaQueAtendeRequisitos.add(new QuestaoDissertativa());

        Mockito.when(buscarQuestaoDissertativaPorEspecificidadeENivelService
                .buscar(buscaQuestoesRequest.getEspecificidade(),
                        buscaQuestoesRequest.getNivelDeDificuldade()))
                .thenReturn(listaQueAtendeRequisitos);
        Mockito.doNothing().when(validator).validar(listaQueAtendeRequisitos.size(), buscaQuestoesRequest.getQuantidadeDeQuestoes());
        listarQuestoesDissertativasFiltradasService.listar(buscaQuestoesRequest);

        Assert.assertEquals(VALOR_ESPERADO_DE_RETORNO_DO_SIZE_DA_LISTA_DE_FILTRADAS,listarQuestoesDissertativasFiltradasService.listar(buscaQuestoesRequest).size());
    }

    @Test
    public void deveChamarBuscarQuestaoDissertativaPorEspecificidadeENivelServiceQuandoListarQuestoesDissertativasFiltradasServiceForChamada() {

        BuscaQuestoesRequest buscaQuestoesRequest =
                new BuscaQuestoesRequest(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 1);

        List<QuestaoDissertativa> listaQueAtendeRequisitos = new ArrayList<>();
        listaQueAtendeRequisitos.add(new QuestaoDissertativa());

        Mockito.when(buscarQuestaoDissertativaPorEspecificidadeENivelService
                .buscar(buscaQuestoesRequest.getEspecificidade(),
                        buscaQuestoesRequest.getNivelDeDificuldade()))
                .thenReturn(listaQueAtendeRequisitos);
        Mockito.doNothing().when(validator).validar(listaQueAtendeRequisitos.size(), buscaQuestoesRequest.getQuantidadeDeQuestoes());

        listarQuestoesDissertativasFiltradasService.listar(buscaQuestoesRequest);

        Mockito.verify(buscarQuestaoDissertativaPorEspecificidadeENivelService).buscar(buscaQuestoesRequest.getEspecificidade(),
                buscaQuestoesRequest.getNivelDeDificuldade());
    }

    @Test
    public void deveChamarQuestaoValidatorQuandoListarQuestoesDissertativasFiltradasServiceForChamadaENaoEncontrarNenhumaQuestao() {

        BuscaQuestoesRequest buscaQuestoesRequest =
                new BuscaQuestoesRequest(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 1);

        List<QuestaoDissertativa> listaQueAtendeRequisitos = new ArrayList<>();
        listaQueAtendeRequisitos.add(new QuestaoDissertativa());
        Mockito.when(buscarQuestaoDissertativaPorEspecificidadeENivelService
                .buscar(buscaQuestoesRequest.getEspecificidade(),
                        buscaQuestoesRequest.getNivelDeDificuldade()))
                .thenReturn(listaQueAtendeRequisitos);
        Mockito.doNothing().when(validator).validar(listaQueAtendeRequisitos.size(), buscaQuestoesRequest.getQuantidadeDeQuestoes());

        listarQuestoesDissertativasFiltradasService.listar(buscaQuestoesRequest);

        Mockito.verify(validator).validar(listaQueAtendeRequisitos.size(), buscaQuestoesRequest.getQuantidadeDeQuestoes());
    }

    @Test
    public void deveRetornarUmaListaDeQuestaoDissertativaQuandoListarQuestoesDissertativasFiltradasServiceForChamadaENaoEncontrarNenhumaQuestao() {

        BuscaQuestoesRequest buscaQuestoesRequest =
                new BuscaQuestoesRequest(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 1);

        List<QuestaoDissertativa> listaQueAtendeRequisitos = new ArrayList<>();
        listaQueAtendeRequisitos.add(new QuestaoDissertativa());
        Mockito.when(buscarQuestaoDissertativaPorEspecificidadeENivelService
                .buscar(buscaQuestoesRequest.getEspecificidade(),
                        buscaQuestoesRequest.getNivelDeDificuldade()))
                .thenReturn(listaQueAtendeRequisitos);
        Mockito.doNothing().when(validator).validar(listaQueAtendeRequisitos.size(), buscaQuestoesRequest.getQuantidadeDeQuestoes());

        listarQuestoesDissertativasFiltradasService.listar(buscaQuestoesRequest);

        Assert.assertEquals(listarQuestoesDissertativasFiltradasService.listar(buscaQuestoesRequest), listaQueAtendeRequisitos);
    }



}