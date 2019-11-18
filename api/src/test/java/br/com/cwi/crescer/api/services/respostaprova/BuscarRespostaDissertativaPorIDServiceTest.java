package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.exception.resposta.RespostaNaoEncontradaException;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.swing.text.html.Option;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class BuscarRespostaDissertativaPorIDServiceTest {

    @InjectMocks
    BuscarRespostaDissertativaPorIDService buscarRespostaDissertativaPorIDService;

    @Mock
    RespostasDissertativaRepository repository;

    @Test
    public void deveChamarRespostasDissertativaRepositoryQuandoBuscarRespostaDissertativaPorIDServiceForChamado() {

        RespostasDissertativaProva respostasDissertativaProva = new RespostasDissertativaProva();

        Mockito.when(repository.findById(respostasDissertativaProva.getId()))
                .thenReturn(Optional.of(respostasDissertativaProva));

        buscarRespostaDissertativaPorIDService.buscar(respostasDissertativaProva.getId());

        Mockito.verify(repository).findById(respostasDissertativaProva.getId());
    }

    @Test
    public void deveRetornarRespostasDissertativaProvaQuandoBuscarRespostaDissertativaPorIDServiceForChamado() {

        RespostasDissertativaProva respostasDissertativaProva = new RespostasDissertativaProva();

        Mockito.when(repository.findById(respostasDissertativaProva.getId()))
                .thenReturn(Optional.of(respostasDissertativaProva));

        buscarRespostaDissertativaPorIDService.buscar(respostasDissertativaProva.getId());

        Assert.assertEquals(buscarRespostaDissertativaPorIDService.buscar(respostasDissertativaProva.getId()), respostasDissertativaProva);
    }

    @Test(expected = RespostaNaoEncontradaException.class)
    public void deveLancarRespostaNaoEncontradaExceptionQuandoBuscarRespostaDissertativaPorIDServiceForChamado() {

        RespostasDissertativaProva respostasDissertativaProva = new RespostasDissertativaProva();

        Mockito.when(repository.findById(respostasDissertativaProva.getId()))
                .thenReturn(Optional.empty());

        buscarRespostaDissertativaPorIDService.buscar(respostasDissertativaProva.getId());

    }
}