package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.enums.StatusProva;
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
public class CancelarProvaServiceTest {

    @InjectMocks
    CancelarProvaService cancelarProvaService;

    @Mock
    ProvaRepository repository;

    @Mock
    BuscarProvaPorIdService buscarProvaPorIdService;

    @Test
    public void deveTornarOStatusDaProvaComoCanceladaQuandoCancelarProvaServiceForChamado() {

        Prova prova = new Prova();
        prova.setStatus(StatusProva.ATIVA);
        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);

        Assert.assertEquals(StatusProva.CANCELADA, cancelarProvaService.cancelar(prova.getId()));

    }

}