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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BuscarQuestoesDissertativasFiltradasListaServiceTest {

    @InjectMocks
    BuscarQuestoesDissertativasFiltradasListaService buscarQuestoesDissertativasFiltradasListaService;

    @Mock
    QuestaoDissertativaRepository repository;

    @Test
    public void deveChamarQuestaoDissertativaRepositoryQuandoBuscarQuestaoDissertativaPorEspecificidadeENivelServiceForChamado() {

        List<QuestaoDissertativa> listaDeQuestoes = new ArrayList<>();
        QuestaoDissertativa questaoDissertativa = new QuestaoDissertativa();
        questaoDissertativa.setEspecificidade(Especificidade.JAVASCRIPT);
        questaoDissertativa.setNivelDeDificuldade(NivelDeDificuldade.FACIL);
        listaDeQuestoes.add(questaoDissertativa);

        Pageable quantos = PageRequest.of(0, 10);
        Mockito.when(repository
                .findByEspecificidadeAndNivelDeDificuldadeOrderByVezesUsadaAsc(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, quantos)).thenReturn(listaDeQuestoes);

        buscarQuestoesDissertativasFiltradasListaService.buscar(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 10);

        Mockito.verify(repository).findByEspecificidadeAndNivelDeDificuldadeOrderByVezesUsadaAsc(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, quantos);
    }

    @Test
    public void deveRetornarUmaListaDeQuestoesSelecionadasPorEspecificidadeENivelQuandoBuscarQuestaoDissertativaPorEspecificidadeENivelServiceForChamado() {

        List<QuestaoDissertativa> listaDeQuestoes = new ArrayList<>();
        QuestaoDissertativa questaoDissertativa = new QuestaoDissertativa();
        questaoDissertativa.setEspecificidade(Especificidade.JAVASCRIPT);
        questaoDissertativa.setNivelDeDificuldade(NivelDeDificuldade.FACIL);
        listaDeQuestoes.add(questaoDissertativa);

        Pageable quantos = PageRequest.of(0, 10);
        Mockito.when(repository
                .findByEspecificidadeAndNivelDeDificuldadeOrderByVezesUsadaAsc(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, quantos)).thenReturn(listaDeQuestoes);

        buscarQuestoesDissertativasFiltradasListaService.buscar(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 10);

        Assert.assertEquals(buscarQuestoesDissertativasFiltradasListaService
                .buscar(Especificidade.JAVASCRIPT,
                NivelDeDificuldade.FACIL, 10).size(), listaDeQuestoes.size());

    }
}