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

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BuscarQuestoesMultiplaEscolhaFiltradasServiceTest {

    @InjectMocks
    BuscarQuestoesMultiplaEscolhaFiltradasService buscarQuestoesMultiplaEscolhaFiltradasService;

    @Mock
    QuestaoMultiplaEscolhaRepository repository;

    @Test
    public void deveChamarQuestaoMultiplaEscolhaRepositoryQuestaoBuscarQuestoesMultiplaEscolhaFiltradasService() {

        List<QuestaoMultiplaEscolha> questaoMultiplaEscolhas = new ArrayList<>();

        Mockito.when(repository.acharPorNivelEEspecificidade(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL))
                .thenReturn(questaoMultiplaEscolhas);

        buscarQuestoesMultiplaEscolhaFiltradasService.buscar(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL);

        Mockito.verify(repository).acharPorNivelEEspecificidade(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL);
    }

    @Test
    public void deveRetornarUmaListaDeQuestaoMultiplaEscolhaQuestaoQuandoBuscarQuestoesMultiplaEscolhaFiltradasService() {

        List<QuestaoMultiplaEscolha> questaoMultiplaEscolhas = new ArrayList<>();

        Mockito.when(repository.acharPorNivelEEspecificidade(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL))
                .thenReturn(questaoMultiplaEscolhas);

        buscarQuestoesMultiplaEscolhaFiltradasService.buscar(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL);

        Assert.assertEquals( buscarQuestoesMultiplaEscolhaFiltradasService
                .buscar(Especificidade.JAVASCRIPT, NivelDeDificuldade.FACIL), questaoMultiplaEscolhas);
    }


}