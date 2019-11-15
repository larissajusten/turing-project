package br.com.cwi.crescer.api.services.questaodissertativa;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.repository.questao.QuestaoDissertativaRepository;
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
public class BuscarQuestaoDissertativaPorEspecificidadeENivelServiceTest {

    @InjectMocks
    BuscarQuestaoDissertativaPorEspecificidadeENivelService buscarQuestaoDissertativaPorEspecificidadeENivelService;

    @Mock
    QuestaoDissertativaRepository repository;

    @Test
    public void deveChamarQuestaoDissertativaRepositoryQuandoBuscarQuestaoDissertativaPorEspecificidadeENivelServiceForChamado() {

        List<QuestaoDissertativa> listaDeQuestoes = new ArrayList<>();
        QuestaoDissertativa questaoDissertativa = new QuestaoDissertativa();
        questaoDissertativa.setEspecificidade(Especificidade.JAVASCRIPT);
        questaoDissertativa.setNivelDeDificuldade(NivelDeDificuldade.FACIL);
        listaDeQuestoes.add(questaoDissertativa);

        Mockito.when(repository.acharPorNivelEEspecificidade(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL)).thenReturn(listaDeQuestoes);

        buscarQuestaoDissertativaPorEspecificidadeENivelService.buscar(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL);

        Mockito.verify(repository).acharPorNivelEEspecificidade(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL);
    }

    @Test
    public void deveRetornarUmaListaDeQuestoesSelecionadasPorEspecificidadeENivelQuandoBuscarQuestaoDissertativaPorEspecificidadeENivelServiceForChamado() {

        List<QuestaoDissertativa> listaDeQuestoes = new ArrayList<>();
        QuestaoDissertativa questaoDissertativa = new QuestaoDissertativa();
        questaoDissertativa.setEspecificidade(Especificidade.JAVASCRIPT);
        questaoDissertativa.setNivelDeDificuldade(NivelDeDificuldade.FACIL);
        listaDeQuestoes.add(questaoDissertativa);

        Mockito.when(repository.acharPorNivelEEspecificidade(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL)).thenReturn(listaDeQuestoes);

        buscarQuestaoDissertativaPorEspecificidadeENivelService.buscar(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL);

        Assert.assertEquals(buscarQuestaoDissertativaPorEspecificidadeENivelService
                .buscar(Especificidade.JAVASCRIPT,
                NivelDeDificuldade.FACIL).size(), listaDeQuestoes.size());

    }
}