package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BuscarDuracaoDaProvaServiceTest {

    @InjectMocks
    BuscarDuracaoDaProvaService buscarDuracaoDaProvaService;

    @Mock
    BuscarProvaPorIdService buscarProvaPorIdService;

    @Test
    public void deveChamarBuscarProvaPorIdServiceQuandoBuscarDuracaoDaProvaServiceForChamado() {

        Prova prova = new Prova();

        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);

        buscarDuracaoDaProvaService.buscar(prova.getId());

        Mockito.verify(buscarProvaPorIdService).buscar(prova.getId());
    }

    @Test
    public void deveRetornarOTempoDeDuracaoDaPovaQuandoBuscarDuracaoDaProvaServiceForChamado() {

        Prova prova = new Prova();

        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);

        buscarDuracaoDaProvaService.buscar(prova.getId());

        Assert.assertEquals(buscarDuracaoDaProvaService.buscar(prova.getId()), prova.getTempoDeDuracaoDaProva());
    }
}