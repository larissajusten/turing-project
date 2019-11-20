package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.exception.questoes.QuestaoNaoEncontradaException;
import br.com.cwi.crescer.api.repository.questao.QuestaoMultiplaEscolhaRepository;
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
public class BuscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeServiceTest {

    @InjectMocks
    BuscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeService buscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeService;

    @Mock
    QuestaoMultiplaEscolhaRepository repository;

    @Test
    public void deveChamarQuestaoMultiplaEscolhaRepositoryDuasVezesQuandoBuscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeServiceForChamada() {

        List<QuestaoMultiplaEscolha> listaDeQuestoes = new ArrayList<>();
        listaDeQuestoes.add(new QuestaoMultiplaEscolha());

        Pageable quantos = PageRequest.of(0, 10);
        Mockito.when(repository
                .findByEspecificidadeAndNivelDeDificuldadeOrderByVezesUsadaDesc(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, quantos)).thenReturn(listaDeQuestoes);

        buscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeService
                .buscar(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 10);

        Mockito.verify(repository, Mockito.times(1)).findByEspecificidadeAndNivelDeDificuldadeOrderByVezesUsadaDesc(Especificidade.JAVASCRIPT,
                NivelDeDificuldade.FACIL, quantos);

    }


    @Test
    public void deveRetornarUmaListaComAsQuestoesQuandoBuscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeServiceForChamada() {

        List<QuestaoMultiplaEscolha> listaDeQuestoes = new ArrayList<>();
        listaDeQuestoes.add(new QuestaoMultiplaEscolha());

        Pageable quantos = PageRequest.of(0, 10);
        Mockito.when(repository
                .findByEspecificidadeAndNivelDeDificuldadeOrderByVezesUsadaDesc(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, quantos)).thenReturn(listaDeQuestoes);

        buscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeService
                .buscar(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 10);

        Assert.assertEquals(buscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeService
                .buscar(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 10).size(), listaDeQuestoes.size());

    }
}