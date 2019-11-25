package br.com.cwi.crescer.api.services.dashboard;

import br.com.cwi.crescer.api.controller.responses.RespostaParaDashboardResponse;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.repository.resposta.RespostasTecnicaRepository;
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
public class BuscarQuestoesTecnicasPorEspecificidadeAgrupadasPorNotaENivelDeDificuldadeServiceTest {

    @InjectMocks
    BuscarQuestoesTecnicasPorEspecificidadeAgrupadasPorNotaENivelDeDificuldadeService buscarQuestoesTecnicasPorEspecificidadeAgrupadasPorNotaENivelDeDificuldadeService;

    @Mock
    RespostasTecnicaRepository repository;

    @Test
    public void deveRetornarUmaListaDeRespostaParaDashboardResponseQuandoBuscarQuestoesTecnicasPorEspecificidadeAgrupadasPorNotaENivelDeDificuldadeServiceForChamado() {
        List<RespostaParaDashboardResponse> lista = new ArrayList<>();

        Mockito.when(repository.buscarQuestoesTecnicasAgrupadasPorNotaENivelDeDificuldade(Especificidade.JAVASCRIPT))
                .thenReturn(lista);

        Assert.assertEquals(lista, buscarQuestoesTecnicasPorEspecificidadeAgrupadasPorNotaENivelDeDificuldadeService.buscar(Especificidade.JAVASCRIPT));
    }

    @Test
    public void deveChamarRespostasTecnicaRepositoryQuandoBuscarQuestoesTecnicasPorEspecificidadeAgrupadasPorNotaENivelDeDificuldadeServiceForChamado() {
        List<RespostaParaDashboardResponse> lista = new ArrayList<>();

        Mockito.when(repository.buscarQuestoesTecnicasAgrupadasPorNotaENivelDeDificuldade(Especificidade.JAVASCRIPT))
                .thenReturn(lista);

        buscarQuestoesTecnicasPorEspecificidadeAgrupadasPorNotaENivelDeDificuldadeService.buscar(Especificidade.JAVASCRIPT);

        Mockito.verify(repository).buscarQuestoesTecnicasAgrupadasPorNotaENivelDeDificuldade(Especificidade.JAVASCRIPT);
    }
}