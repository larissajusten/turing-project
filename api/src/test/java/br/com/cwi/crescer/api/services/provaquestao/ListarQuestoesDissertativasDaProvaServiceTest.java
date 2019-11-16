package br.com.cwi.crescer.api.services.provaquestao;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoDissertativaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoDissertativa;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ListarQuestoesDissertativasDaProvaServiceTest {

    @InjectMocks
    ListarQuestoesDissertativasDaProvaService listarQuestoesDissertativasDaProvaService;

    @Mock
    ProvaQuestaoDissertativaRepository repository;

    @Test
    public void deveChamar() {

        Prova prova = new Prova();

        List<ProvaQuestaoDissertativa> questoes = new ArrayList<>();

        Mockito.when(repository.findAllByProvaIdEquals(prova.getId())).thenReturn(questoes);

        listarQuestoesDissertativasDaProvaService.listar(prova.getId());

        Mockito.verify(repository).findAllByProvaIdEquals(prova.getId());
    }

}