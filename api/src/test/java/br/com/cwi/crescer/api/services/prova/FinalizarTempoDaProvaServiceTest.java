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

import java.time.LocalDate;
import java.time.LocalDateTime;

@RunWith(MockitoJUnitRunner.class)
public class FinalizarTempoDaProvaServiceTest {

    @InjectMocks
    FinalizarTempoDaProvaService finalizarTempoDaProvaService;

    @Mock
    BuscarProvaPorIdService buscarProvaPorIdService;

    @Mock
    ProvaRepository repository;

    @Test
    public void deveChamarProvaRepositoryQuandoFinalizarTempoDaProvaServiceForChamado() {
        Prova prova = new Prova();
        LocalDateTime agora = LocalDateTime.now();
        prova.setDataInicio(LocalDateTime.now());
        prova.setTempoDeDuracaoDaProva(1);

        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);

        finalizarTempoDaProvaService.finalizar(prova.getId());

        Mockito.verify(repository).save(prova);

    }

    @Test
    public void deveChamarBuscarProvaPorIdServiceQuandoFinalizarTempoDaProvaServiceForChamado() {
        Prova prova = new Prova();
        prova.setDataInicio(LocalDateTime.now());
        prova.setTempoDeDuracaoDaProva(1);

        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);

        finalizarTempoDaProvaService.finalizar(prova.getId());

        Mockito.verify(buscarProvaPorIdService).buscar(prova.getId());

    }

    @Test
    public void deveSetarStatusProvaAguardandoCorrecaoQuandoFinalizarTempoDaProvaServiceForChamado() {
        Prova prova = new Prova();
        prova.setDataInicio(LocalDateTime.of(LocalDate.of(1988, 10, 10), LocalDateTime.now().toLocalTime()));
        prova.setTempoDeDuracaoDaProva(1);

        Mockito.when(buscarProvaPorIdService.buscar(prova.getId())).thenReturn(prova);

        finalizarTempoDaProvaService.finalizar(prova.getId());

        Assert.assertEquals(StatusProva.AGUARDANDO_CORRECAO, finalizarTempoDaProvaService.finalizar(prova.getId()));

    }


}