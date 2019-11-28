package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.requests.questoes.BuscaQuestoesRequest;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoTecnica;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoTecnicaRepository;
import br.com.cwi.crescer.api.services.questaotecnica.AcrescentarQuantasVezesUsadaQuestaoTecnicaService;
import br.com.cwi.crescer.api.services.questaotecnica.IncluirQuestoesTecnicasService;
import br.com.cwi.crescer.api.services.questaotecnica.ListarQuestoesTecnicasFiltradasService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class IncluirQuestoesTecnicasServiceTest {

    @InjectMocks
    IncluirQuestoesTecnicasService incluirQuestoesTecnicasService;

    @Mock
    ListarQuestoesTecnicasFiltradasService listarQuestoesTecnicasFiltradasService;

    @Mock
    BuscarProvaPorIdService buscarProvaPorId;

    @Mock
    ProvaQuestaoTecnicaRepository repository;

    @Mock
    AcrescentarQuantasVezesUsadaQuestaoTecnicaService acrescentarQuantasVezesUsadaQuestaoTecnicaService;

    @Test
    public void deveChamarListarQuestoesTecnicasFiltradasServiceQuandoIncluirQuestoesTecnicasServiceForChamado() {
        BuscaQuestoesRequest buscaQuestoesRequest =
                new BuscaQuestoesRequest(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 1);
        List<QuestaoTecnica> lista = new ArrayList<>();
        QuestaoTecnica questao = new QuestaoTecnica();
        lista.add(questao);
        Prova prova = new Prova();
        ProvaQuestaoTecnica provaQuestaoTecnica = new ProvaQuestaoTecnica();
        provaQuestaoTecnica.setProva(prova);
        provaQuestaoTecnica.setQuestao(questao);

        Mockito.when(listarQuestoesTecnicasFiltradasService.listar(buscaQuestoesRequest)).thenReturn(lista);
        Mockito.when(buscarProvaPorId.buscar(prova.getId())).thenReturn(prova);
        Mockito.when(repository.save(provaQuestaoTecnica)).thenReturn(provaQuestaoTecnica);

        incluirQuestoesTecnicasService.incluir(prova.getId(), buscaQuestoesRequest);

        Mockito.verify(listarQuestoesTecnicasFiltradasService).listar(buscaQuestoesRequest);

    }

    @Test
    public void deveChamarBuscarProvaPorIdServiceQuandoIncluirQuestoesTecnicasServiceForChamado() {
        BuscaQuestoesRequest buscaQuestoesRequest =
                new BuscaQuestoesRequest(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 1);
        List<QuestaoTecnica> lista = new ArrayList<>();
        QuestaoTecnica questao = new QuestaoTecnica();
        lista.add(questao);
        Prova prova = new Prova();
        ProvaQuestaoTecnica provaQuestaoTecnica = new ProvaQuestaoTecnica();
        provaQuestaoTecnica.setProva(prova);
        provaQuestaoTecnica.setQuestao(questao);

        Mockito.when(listarQuestoesTecnicasFiltradasService.listar(buscaQuestoesRequest)).thenReturn(lista);
        Mockito.when(buscarProvaPorId.buscar(prova.getId())).thenReturn(prova);
        Mockito.when(repository.save(provaQuestaoTecnica)).thenReturn(provaQuestaoTecnica);

        incluirQuestoesTecnicasService.incluir(prova.getId(), buscaQuestoesRequest);

        Mockito.verify(buscarProvaPorId).buscar(prova.getId());

    }

    @Test
    public void deveChamarProvaQuestaoTecnicaRepositoryQuandoIncluirQuestoesTecnicasServiceForChamado() {
        BuscaQuestoesRequest buscaQuestoesRequest =
                new BuscaQuestoesRequest(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 1);
        List<QuestaoTecnica> lista = new ArrayList<>();
        QuestaoTecnica questao = new QuestaoTecnica();
        lista.add(questao);
        Prova prova = new Prova();
        ProvaQuestaoTecnica provaQuestaoTecnica = new ProvaQuestaoTecnica();
        provaQuestaoTecnica.setProva(prova);
        provaQuestaoTecnica.setQuestao(questao);

        Mockito.when(listarQuestoesTecnicasFiltradasService.listar(buscaQuestoesRequest)).thenReturn(lista);
        Mockito.when(buscarProvaPorId.buscar(prova.getId())).thenReturn(prova);
        Mockito.when(repository.save(provaQuestaoTecnica)).thenReturn(provaQuestaoTecnica);

        incluirQuestoesTecnicasService.incluir(prova.getId(), buscaQuestoesRequest);

        Mockito.verify(repository).save(provaQuestaoTecnica);

    }

    @Test
    public void deveChamarAcrescentarQuantiaDeVezesUsadaQuestaoTecnicaQuandoIncluirQuestoesTecnicasServiceForChamado() {
        BuscaQuestoesRequest buscaQuestoesRequest =
                new BuscaQuestoesRequest(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 1);
        List<QuestaoTecnica> lista = new ArrayList<>();
        QuestaoTecnica questao = new QuestaoTecnica();
        lista.add(questao);
        Prova prova = new Prova();
        ProvaQuestaoTecnica provaQuestaoTecnica = new ProvaQuestaoTecnica();
        provaQuestaoTecnica.setProva(prova);
        provaQuestaoTecnica.setQuestao(questao);

        Mockito.when(listarQuestoesTecnicasFiltradasService.listar(buscaQuestoesRequest)).thenReturn(lista);
        Mockito.when(buscarProvaPorId.buscar(prova.getId())).thenReturn(prova);
        Mockito.when(repository.save(provaQuestaoTecnica)).thenReturn(provaQuestaoTecnica);

        incluirQuestoesTecnicasService.incluir(prova.getId(), buscaQuestoesRequest);

        Mockito.verify(acrescentarQuantasVezesUsadaQuestaoTecnicaService).acrescentar(lista);

    }


}