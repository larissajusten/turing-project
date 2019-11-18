package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoMultiplaEscolhaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExcluirQuestaoMultiplaEscolhaServiceTest {

    @InjectMocks
    ExcluirQuestaoMultiplaEscolhaService excluirQuestaoMultiplaEscolhaService;

    @Mock
    ProvaQuestaoMultiplaEscolhaRepository repository;

    @Test
    public void deveChamarProvaQuestaoMultiplaEscolhaRepositoryQuandoExcluirQuestaoMultiplaEscolhaServiceForChamado() {
        QuestaoMultiplaEscolha questaoMultiplaEscolha = new QuestaoMultiplaEscolha();

        excluirQuestaoMultiplaEscolhaService.excluir(questaoMultiplaEscolha.getId());

        Mockito.verify(repository).deleteById(questaoMultiplaEscolha.getId());
    }
}