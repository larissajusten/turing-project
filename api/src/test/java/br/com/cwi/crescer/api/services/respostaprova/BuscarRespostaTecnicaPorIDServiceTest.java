package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.resposta.RespostasTecnicaProva;
import br.com.cwi.crescer.api.exception.resposta.RespostaNaoEncontradaException;
import br.com.cwi.crescer.api.repository.resposta.RespostasTecnicaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class BuscarRespostaTecnicaPorIDServiceTest {

    @InjectMocks
    BuscarRespostaTecnicaPorIDService buscarRespostaTecnicaPorIDService;

    @Mock
    RespostasTecnicaRepository repository;

    @Test
    public void deveChamarRespostasTecnicaRepositoryQuandoBuscarRespostaTecnicaPorIDServiceForChamado() {

        RespostasTecnicaProva reposta = new RespostasTecnicaProva();

        Mockito.when(repository.findById(reposta.getId())).thenReturn(Optional.of(reposta));

        buscarRespostaTecnicaPorIDService.buscar(reposta.getId());

        Mockito.verify(repository).findById(reposta.getId());

    }

    @Test(expected = RespostaNaoEncontradaException.class)
    public void deveLancarRespostaNaoEncontradaExceptionQuandoBuscarRespostaTecnicaPorIDServiceForChamado() {

        RespostasTecnicaProva reposta = new RespostasTecnicaProva();

        Mockito.when(repository.findById(reposta.getId())).thenReturn(Optional.empty());

        buscarRespostaTecnicaPorIDService.buscar(reposta.getId());

    }

    @Test
    public void deveRetornarRespostasTecnicaProvaQuandoBuscarRespostaTecnicaPorIDServiceForChamado() {

        RespostasTecnicaProva reposta = new RespostasTecnicaProva();

        Mockito.when(repository.findById(reposta.getId())).thenReturn(Optional.of(reposta));

        buscarRespostaTecnicaPorIDService.buscar(reposta.getId());

        Assert.assertEquals(buscarRespostaTecnicaPorIDService.buscar(reposta.getId()), reposta);

    }
}