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

        Mockito.when(repository.acharPorNivelEEspecificidade(Especificidade.JAVASCRIPT,
                NivelDeDificuldade.FACIL)).thenReturn(listaDeQuestoes);

        buscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeService
                .buscarQuestoes(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL);

        Mockito.verify(repository, Mockito.times(1)).acharPorNivelEEspecificidade(Especificidade.JAVASCRIPT,
                NivelDeDificuldade.FACIL);

    }


    @Test
    public void deveRetornarUmaListaComAsQuestoesQuandoBuscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeServiceForChamada() {

        List<QuestaoMultiplaEscolha> listaDeQuestoes = new ArrayList<>();
        listaDeQuestoes.add(new QuestaoMultiplaEscolha());

        Mockito.when(repository.acharPorNivelEEspecificidade(Especificidade.JAVASCRIPT,
                NivelDeDificuldade.FACIL)).thenReturn(listaDeQuestoes);

        buscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeService
                .buscarQuestoes(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL);

        Assert.assertEquals(buscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeService
                .buscarQuestoes(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL).size(), listaDeQuestoes.size());

    }
}