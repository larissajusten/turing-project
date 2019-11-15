package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.exception.questoes.QuestaoNaoEncontradaException;
import br.com.cwi.crescer.api.repository.questao.QuestaoMultiplaEscolhaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class BuscarQuestaoMultiplaEscolhaPorIdServiceTest {

    @InjectMocks
    BuscarQuestaoMultiplaEscolhaPorIdService buscarQuestaoMultiplaEscolhaPorIdService;

    @Mock
    QuestaoMultiplaEscolhaRepository repository;

    @Test
    public void deveChamarQuestaoMultiplaEscolhaRepositoryQuandoBuscarQuestaoMultiplaEscolhaPorIdServiceForChamado() {

        QuestaoMultiplaEscolha questao = new QuestaoMultiplaEscolha();

        Mockito.when(repository.findById(questao.getId())).thenReturn(Optional.of(questao));

        buscarQuestaoMultiplaEscolhaPorIdService.buscar(questao.getId());

        Mockito.verify(repository).findById(questao.getId());

    }

    @Test(expected = QuestaoNaoEncontradaException.class)
    public void deveLancarUmaExceptionQuandoBuscarQuestaoMultiplaEscolhaPorIdServiceForChamadoENaoRetornarUmaQuestao() {

        QuestaoMultiplaEscolha questao = new QuestaoMultiplaEscolha();

        Mockito.when(repository.findById(questao.getId())).thenReturn(Optional.ofNullable(null));

        buscarQuestaoMultiplaEscolhaPorIdService.buscar(questao.getId());



    }

}