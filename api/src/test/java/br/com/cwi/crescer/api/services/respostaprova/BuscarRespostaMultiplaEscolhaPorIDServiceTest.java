package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.resposta.RespostasMultiplaEscolhaProva;
import br.com.cwi.crescer.api.exception.resposta.RespostaNaoEncontradaException;
import br.com.cwi.crescer.api.repository.resposta.RespostaMultiplaEscolhaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class BuscarRespostaMultiplaEscolhaPorIDServiceTest {

    @InjectMocks
    BuscarRespostaMultiplaEscolhaPorIDService buscarRespostaMultiplaEscolhaPorIDService;

    @Mock
    RespostaMultiplaEscolhaRepository repository;

    @Test
    public void deveChamarRespostaMultiplaEscolhaRepositoryQuandoBuscarRespostaMultiplaEscolhaPorIDService() {

        RespostasMultiplaEscolhaProva respostasMultiplaEscolhaProva = new RespostasMultiplaEscolhaProva();

        Mockito.when(repository.findById(respostasMultiplaEscolhaProva.getId()))
                .thenReturn(Optional.of(respostasMultiplaEscolhaProva));

        buscarRespostaMultiplaEscolhaPorIDService.buscar(respostasMultiplaEscolhaProva.getId());

        Mockito.verify(repository).findById(respostasMultiplaEscolhaProva.getId());

    }

    @Test
    public void deveRetornarRespostasMultiplaEscolhaProvaQuandoBuscarRespostaMultiplaEscolhaPorIDService() {

        RespostasMultiplaEscolhaProva respostasMultiplaEscolhaProva = new RespostasMultiplaEscolhaProva();

        Mockito.when(repository.findById(respostasMultiplaEscolhaProva.getId()))
                .thenReturn(Optional.of(respostasMultiplaEscolhaProva));

        buscarRespostaMultiplaEscolhaPorIDService.buscar(respostasMultiplaEscolhaProva.getId());

        Assert.assertEquals(buscarRespostaMultiplaEscolhaPorIDService
                .buscar(respostasMultiplaEscolhaProva.getId()),respostasMultiplaEscolhaProva);

    }

    @Test(expected = RespostaNaoEncontradaException.class)
    public void deveLancarRespostaNaoEncontradaExceptionQuandoBuscarRespostaMultiplaEscolhaPorIDService() {

        RespostasMultiplaEscolhaProva respostasMultiplaEscolhaProva = new RespostasMultiplaEscolhaProva();

        Mockito.when(repository.findById(respostasMultiplaEscolhaProva.getId()))
                .thenReturn(Optional.empty());

        buscarRespostaMultiplaEscolhaPorIDService.buscar(respostasMultiplaEscolhaProva.getId());

    }
}