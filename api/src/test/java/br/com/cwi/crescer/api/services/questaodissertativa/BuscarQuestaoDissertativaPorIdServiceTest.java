package br.com.cwi.crescer.api.services.questaodissertativa;

import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.exception.questoes.QuestaoNaoEncontradaException;
import br.com.cwi.crescer.api.repository.questao.QuestaoDissertativaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class BuscarQuestaoDissertativaPorIdServiceTest {

    @InjectMocks
    BuscarQuestaoDissertativaPorIdService buscarQuestaoDissertativaPorIdService;

    @Mock
    QuestaoDissertativaRepository repository;

    @Test
    public void deveChamarQuestaoDissertativaRepositoryQuandoBuscarQuestaoDissertativaPorIdServiceForChamado() {

        QuestaoDissertativa questao = new QuestaoDissertativa();

        Mockito.when(repository.findById(questao.getId())).thenReturn(Optional.of(questao));

        buscarQuestaoDissertativaPorIdService.buscar(questao.getId());

        Mockito.verify(repository).findById(questao.getId());
    }

    @Test(expected = QuestaoNaoEncontradaException.class)
    public void deveLancarQuestaoNaoEncontradaExceptionQuandoBuscarQuestaoDissertativaPorIdServiceNaoAcharAQuestao() {

        QuestaoDissertativa questao = new QuestaoDissertativa();

        Mockito.when(repository.findById(questao.getId())).thenReturn(Optional.ofNullable(null));

        buscarQuestaoDissertativaPorIdService.buscar(questao.getId());

    }


}