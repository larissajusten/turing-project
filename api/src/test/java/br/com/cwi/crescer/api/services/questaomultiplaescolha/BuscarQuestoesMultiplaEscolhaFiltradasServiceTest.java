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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BuscarQuestoesMultiplaEscolhaFiltradasServiceTest {

    @InjectMocks
    BuscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeService buscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeService;

    @Mock
    QuestaoMultiplaEscolhaRepository repository;

    @Test
    public void deveChamarQuestaoMultiplaEscolhaRepositoryQuestaoBuscarQuestoesMultiplaEscolhaFiltradasService() {

        List<QuestaoMultiplaEscolha> questaoMultiplaEscolhas = new ArrayList<>();
        Pageable quantos = PageRequest.of(0, 10);
        Mockito.when(repository
                .findByEspecificidadeAndNivelDeDificuldadeOrderByVezesUsadaDesc(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, quantos))
                .thenReturn(questaoMultiplaEscolhas);

        buscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeService.buscar(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 10);

        Mockito.verify(repository)
                                .findByEspecificidadeAndNivelDeDificuldadeOrderByVezesUsadaDesc(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, quantos);
   }

    @Test
    public void deveRetornarUmaListaDeQuestaoMultiplaEscolhaQuestaoQuandoBuscarQuestoesMultiplaEscolhaFiltradasService() {

        List<QuestaoMultiplaEscolha> questaoMultiplaEscolhas = new ArrayList<>();
        Pageable quantos = PageRequest.of(0, 10);

        Mockito.when(repository
                .findByEspecificidadeAndNivelDeDificuldadeOrderByVezesUsadaDesc(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, quantos))
                .thenReturn(questaoMultiplaEscolhas);

        buscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeService.buscar(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 10);

        Assert.assertEquals( buscarQuestaoMultiplaEscolhaPorNivelEEspecificidadeService
                .buscar(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL, 10), questaoMultiplaEscolhas);
    }


}