package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.repository.questao.QuestaoMultiplaEscolhaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BuscarQuestaoMultiplaEscolhaPorNivelEEspecificidadePaginadoServiceTest {

    @InjectMocks
    BuscarQuestaoMultiplaEscolhaPorNivelEEspecificidadePaginadoService buscarQuestaoMultiplaEscolhaPorNivelEEspecificidadePaginadoService;

    @Mock
    QuestaoMultiplaEscolhaRepository respository;

    @Test
    public void deveChamarQuestaoMultiplaEscolhaRepositoryQuandoBuscarQuestaoMultiplaEscolhaPorNivelEEspecificidadePaginadoServiceForChamado() {
        PageRequest page = PageRequest.of(1, 10);
        List<QuestaoMultiplaEscolha> questoes = new ArrayList<>();
        QuestaoMultiplaEscolha questao = new QuestaoMultiplaEscolha();
        questoes.add(questao);

        Page<QuestaoMultiplaEscolha> buscarQuestoes = new PageImpl<>(questoes, page, questoes.size());

        Mockito.when(respository.acharPorNivelEEspecificidade(page, Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL))
                .thenReturn(buscarQuestoes);

        buscarQuestaoMultiplaEscolhaPorNivelEEspecificidadePaginadoService
                .buscarQuestoes(page, Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL);

        Mockito.verify(respository).acharPorNivelEEspecificidade(page, Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL);

    }

    @Test
    public void deveRetornarUmaPaginaDeQuestaoMultiplaEscolhaQuandoBuscarQuestaoMultiplaEscolhaPorNivelEEspecificidadePaginadoServiceForChamado() {
        PageRequest page = PageRequest.of(1, 10);
        List<QuestaoMultiplaEscolha> questoes = new ArrayList<>();
        QuestaoMultiplaEscolha questao = new QuestaoMultiplaEscolha();
        questoes.add(questao);

        Page<QuestaoMultiplaEscolha> buscarQuestoes = new PageImpl<>(questoes, page, questoes.size());

        Mockito.when(respository.acharPorNivelEEspecificidade(page, Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL))
                .thenReturn(buscarQuestoes);

        buscarQuestaoMultiplaEscolhaPorNivelEEspecificidadePaginadoService
                .buscarQuestoes(page, Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL);

        Assert.assertEquals(buscarQuestoes, buscarQuestaoMultiplaEscolhaPorNivelEEspecificidadePaginadoService
                .buscarQuestoes(page, Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL));

    }

}