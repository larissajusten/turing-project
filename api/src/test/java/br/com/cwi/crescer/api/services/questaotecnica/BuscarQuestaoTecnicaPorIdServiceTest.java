package br.com.cwi.crescer.api.services.questaotecnica;

import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.exception.questoes.QuestaoNaoEncontradaException;
import br.com.cwi.crescer.api.repository.questao.QuestaoTecnicaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class BuscarQuestaoTecnicaPorIdServiceTest {

    @InjectMocks
    BuscarQuestaoTecnicaPorIdService buscarQuestaoTecnicaPorIdService;

    @Mock
    QuestaoTecnicaRepository repository;

    @Test
    public void deveChamarQuestaoTecnicaRepositoryQuandoBuscarQuestaoTecnicaPorIdServiceForChamada() {

        QuestaoTecnica questaoTecnica = new QuestaoTecnica();

        Mockito.when(repository.findById(questaoTecnica.getId())).thenReturn(Optional.of(questaoTecnica));

        buscarQuestaoTecnicaPorIdService.buscar(questaoTecnica.getId());

        Mockito.verify(repository).findById(questaoTecnica.getId());

    }

    @Test(expected = QuestaoNaoEncontradaException.class)
    public void deveDispararValidacaoExceptionQuandoBuscarQuestaoTecnicaPorIdServiceENaoAcharUsuarioForChamada() {

        QuestaoTecnica questaoTecnica = new QuestaoTecnica();

        Mockito.when(repository.findById(questaoTecnica.getId())).thenReturn(Optional.ofNullable(null));

        buscarQuestaoTecnicaPorIdService.buscar(questaoTecnica.getId());

    }

}