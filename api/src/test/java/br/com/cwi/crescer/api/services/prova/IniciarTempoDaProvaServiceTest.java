package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IniciarTempoDaProvaServiceTest {

    @InjectMocks
    IniciarTempoDaProvaService iniciarTempoDaProvaService;

    @Mock
    BuscarProvaPorIdService buscarProvaPorIdService;

    @Mock
    ProvaRepository repository;

    @Test
    public void deveChamarBuscarProvaPorIdServiceQuandoIniciarTempoDaProvaServiceForChamado() {

        Prova prova = new Prova();

        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);

        iniciarTempoDaProvaService.iniciar(prova.getId());

        Mockito.verify(buscarProvaPorIdService).buscar(prova.getId());
    }
}