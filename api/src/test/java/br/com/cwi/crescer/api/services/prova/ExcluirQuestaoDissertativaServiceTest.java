package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoDissertativaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExcluirQuestaoDissertativaServiceTest {

    @InjectMocks
    ExcluirQuestaoDissertativaService excluirQuestaoDissertativaService;

    @Mock
    ProvaQuestaoDissertativaRepository repository;

    @Test
    public void deveChamarProvaQuestaoDissertativaRepositoryQuandoExcluirQuestaoDissertativaServiceForChamado() {

        QuestaoDissertativa questaoDissertativa = new QuestaoDissertativa();

        excluirQuestaoDissertativaService.excluir(questaoDissertativa.getId());

        Mockito.verify(repository).deleteById(questaoDissertativa.getId());

    }
}