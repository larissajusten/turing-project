package br.com.cwi.crescer.api.services.questaotecnica;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.exception.questoes.QuestaoNaoEncontradaException;
import br.com.cwi.crescer.api.repository.questao.QuestaoTecnicaRepository;
import br.com.cwi.crescer.api.services.questaotecnica.BuscarQuestoesTecnicasFiltradasService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BuscarQuestoesTecnicasFiltradasServiceTest {

    @InjectMocks
    BuscarQuestoesTecnicasFiltradasService buscarQuestoesTecnicasFiltradasService;

    @Mock
    QuestaoTecnicaRepository repository;

    @Test(expected = QuestaoNaoEncontradaException.class)
    public void deveChamar() {

        List<QuestaoTecnica> listaDeQuestoes = new ArrayList<>();

        Mockito.when(repository.acharPorNivelEEspecificidade(Especificidade.JAVASCRIPT,
                NivelDeDificuldade.FACIL))
                .thenReturn(listaDeQuestoes);

        buscarQuestoesTecnicasFiltradasService.buscar(Especificidade.JAVASCRIPT,
                NivelDeDificuldade.FACIL);
    }
}