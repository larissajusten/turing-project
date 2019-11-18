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
public class ConsultarStatusDaProvaServiceTest {

    @InjectMocks
    ConsultarStatusDaProvaService consultarStatusDaProvaService;

    @Mock
    BuscarProvaPorIdService buscarProvaPorIdService;

    @Mock
    ProvaRepository repository;

    @Test
    public void deveChamarBuscarProvaPorIdServiceQuandoConsultarStatusDaProvaServiceForChamado() {

        Prova prova = new Prova();

        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);

        consultarStatusDaProvaService.consultar(prova.getId());

        Mockito.verify(buscarProvaPorIdService).buscar(prova.getId());

    }


    @Test
    public void deveRetornarStatusProvaQuandoConsultarStatusDaProvaServiceForChamado() {

        Prova prova = new Prova();

        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);

        consultarStatusDaProvaService.consultar(prova.getId());

        Assert.assertEquals(consultarStatusDaProvaService.consultar(prova.getId()), prova.getStatus());

    }
}