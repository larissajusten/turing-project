package br.com.cwi.crescer.api.services.dashboard;

import br.com.cwi.crescer.api.controller.responses.RespostaParaDashboardResponse;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
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
public class BuscarQuestoesDissertativasPorEspecificidadeAgrupadasPorNotaENivelDeDificuldadeServiceTest {

    @InjectMocks
    BuscarQuestoesDissertativasPorEspecificidadeAgrupadasPorNotaENivelDeDificuldadeService buscarQuestoesDissertativasPorEspecificidadeAgrupadasPorNotaENivelDeDificuldadeService;

    @Mock
    RespostasDissertativaRepository repository;

    @Test
    public void deveRetornarUmaListaDeRespostaParaDashboardResponseQuandoBuscarQuestoesDissertativasPorEspecificidadeAgrupadasPorNotaENivelDeDificuldadeServiceForChamado() {

        List<RespostaParaDashboardResponse> listaResponse = new ArrayList<>();

        Mockito.when(repository.findAllByGroupByNotaWhereQuestaoDissertativaEspecificidadeEquals(Especificidade.JAVASCRIPT))
                .thenReturn(listaResponse);

        Assert.assertEquals(listaResponse, buscarQuestoesDissertativasPorEspecificidadeAgrupadasPorNotaENivelDeDificuldadeService
                .buscar(Especificidade.JAVASCRIPT));
    }

    @Test
    public void deveChamarRespostasDissertativaRepositoryQuandoBuscarQuestoesDissertativasPorEspecificidadeAgrupadasPorNotaENivelDeDificuldadeServiceForChamado() {

        List<RespostaParaDashboardResponse> listaResponse = new ArrayList<>();

        Mockito.when(repository.findAllByGroupByNotaWhereQuestaoDissertativaEspecificidadeEquals(Especificidade.JAVASCRIPT))
                .thenReturn(listaResponse);

        buscarQuestoesDissertativasPorEspecificidadeAgrupadasPorNotaENivelDeDificuldadeService
                .buscar(Especificidade.JAVASCRIPT);

        Mockito.verify(repository).findAllByGroupByNotaWhereQuestaoDissertativaEspecificidadeEquals(Especificidade.JAVASCRIPT);
    }

}