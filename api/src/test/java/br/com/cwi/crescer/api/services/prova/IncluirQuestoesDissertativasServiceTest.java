package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoDissertativa;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoDissertativaRepository;
import br.com.cwi.crescer.api.services.questaodissertativa.AcrescentarQuantasVezesUsadaQuestaoDissertativaService;
import br.com.cwi.crescer.api.services.questaodissertativa.IncluirQuestoesDissertativasService;
import br.com.cwi.crescer.api.services.questaodissertativa.ListarQuestoesDissertativasFiltradasService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class IncluirQuestoesDissertativasServiceTest {

    @InjectMocks
    IncluirQuestoesDissertativasService incluirQuestoesDissertativasService;

    @Mock
    BuscarProvaPorIdService buscarProvaPorIdService;

    @Mock
    ListarQuestoesDissertativasFiltradasService listarQuestoesDissertativasFiltradas;

    @Mock
    ProvaQuestaoDissertativaRepository provaQuestaoDissertativaRepository;

    @Mock
    AcrescentarQuantasVezesUsadaQuestaoDissertativaService acrescentarQuantasVezesUsadaQuestaoDissertativaService;

    @Test
    public void deveChamarListarQuestoesDissertativasFiltradasQuandoIncluirQuestoesDissertativasServiceForChamado() {

        List<QuestaoDissertativa> lista = new ArrayList<>();

        Prova prova = new Prova();

        BuscaQuestoesRequest buscaQuestoesRequest = new BuscaQuestoesRequest(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 1);

        ProvaQuestaoDissertativa provaQuestaoDissertativa = new ProvaQuestaoDissertativa();

        Mockito.when(listarQuestoesDissertativasFiltradas.listar(buscaQuestoesRequest)).thenReturn(lista);
        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);

        incluirQuestoesDissertativasService.incluir(prova.getId(), buscaQuestoesRequest);

        Mockito.verify(listarQuestoesDissertativasFiltradas).listar(buscaQuestoesRequest);

    }

    @Test
    public void deveChamarBuscarProvaPorIdServiceQuandoIncluirQuestoesDissertativasServiceForChamado() {

        List<QuestaoDissertativa> lista = new ArrayList<>();

        Prova prova = new Prova();

        BuscaQuestoesRequest buscaQuestoesRequest = new BuscaQuestoesRequest(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 1);

        ProvaQuestaoDissertativa provaQuestaoDissertativa = new ProvaQuestaoDissertativa();

        Mockito.when(listarQuestoesDissertativasFiltradas.listar(buscaQuestoesRequest)).thenReturn(lista);
        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);

        incluirQuestoesDissertativasService.incluir(prova.getId(), buscaQuestoesRequest);

        Mockito.verify(buscarProvaPorIdService).buscar(prova.getId());

    }

    @Test
    public void deveChamarProvaQuestaoDissertativaRepositoryQuandoIncluirQuestoesDissertativasServiceForChamado() {

        List<QuestaoDissertativa> lista = new ArrayList<>();
        QuestaoDissertativa questao = new QuestaoDissertativa();
        lista.add(questao);

        Prova prova = new Prova();

        BuscaQuestoesRequest buscaQuestoesRequest =
                new BuscaQuestoesRequest(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 1);

        ProvaQuestaoDissertativa provaQuestaoDissertativa = new ProvaQuestaoDissertativa();
        provaQuestaoDissertativa.setProva(prova);
        provaQuestaoDissertativa.setQuestao(questao);

        Mockito.when(listarQuestoesDissertativasFiltradas.listar(buscaQuestoesRequest)).thenReturn(lista);
        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);
        Mockito.when(provaQuestaoDissertativaRepository.save(provaQuestaoDissertativa)).thenReturn(provaQuestaoDissertativa);

        incluirQuestoesDissertativasService.incluir(prova.getId(), buscaQuestoesRequest);

        Mockito.verify(provaQuestaoDissertativaRepository, Mockito.times(1)).save(provaQuestaoDissertativa);

    }

    @Test
    public void deveChamarAcrescentarQuantiaDeVezesUsadaQuestaoDissertativaServiceQuandoIncluirQuestoesDissertativasServiceForChamado() {

        List<QuestaoDissertativa> lista = new ArrayList<>();
        QuestaoDissertativa questao = new QuestaoDissertativa();
        lista.add(questao);

        Prova prova = new Prova();

        BuscaQuestoesRequest buscaQuestoesRequest =
                new BuscaQuestoesRequest(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 1);

        ProvaQuestaoDissertativa provaQuestaoDissertativa = new ProvaQuestaoDissertativa();
        provaQuestaoDissertativa.setProva(prova);
        provaQuestaoDissertativa.setQuestao(questao);

        Mockito.when(listarQuestoesDissertativasFiltradas.listar(buscaQuestoesRequest)).thenReturn(lista);
        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);
        Mockito.when(provaQuestaoDissertativaRepository.save(provaQuestaoDissertativa)).thenReturn(provaQuestaoDissertativa);

        incluirQuestoesDissertativasService.incluir(prova.getId(), buscaQuestoesRequest);

        Mockito.verify(acrescentarQuantasVezesUsadaQuestaoDissertativaService,
                Mockito.times(1)).acrescentar(lista);

    }
}