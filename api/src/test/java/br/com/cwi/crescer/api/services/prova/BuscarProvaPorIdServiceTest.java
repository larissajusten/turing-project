package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.exception.prova.ProvaNaoEncontradaException;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class BuscarProvaPorIdServiceTest {

    @InjectMocks
    BuscarProvaPorIdService buscarProvaPorIdService;

    @Mock
    ProvaRepository repository;

    @Test
    public void deveChamarProvaRepositoryQuandoBuscarProvaPorIdServiceForChamada() {

        Prova prova = new Prova();
        Mockito.when(repository.findById(prova.getId())).thenReturn(Optional.of(prova));

        buscarProvaPorIdService.buscar(prova.getId());

        Mockito.verify(repository).findById(prova.getId());

    }

    @Test(expected = ProvaNaoEncontradaException.class)
    public void deveLancarUmaExceptionQuandoBuscarProvaPorIdServiceNaoRetornarUmaProva() {
        Prova prova = new Prova();
        Mockito.when(repository.findById(prova.getId())).thenReturn(Optional.ofNullable(null));

        buscarProvaPorIdService.buscar(prova.getId());

        Mockito.verify(repository).findById(prova.getId());
    }

}