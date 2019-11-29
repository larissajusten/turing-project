package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.ProvaResponse;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.exception.prova.ProvaNaoEncontradaException;
import br.com.cwi.crescer.api.services.email.JwtTokenProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;


@RunWith(MockitoJUnitRunner.class)
public class BuscarProvaPorTokenComQuestoesServiceTest {

    @InjectMocks
    BuscarProvaPorTokenComQuestoesService buscarProvaPorTokenComQuestoesService;

    @Mock
    BuscarProvaPorIdComQuestoesService buscarProvaPorIdComQuestoesService;

    @Mock
    JwtTokenProvider jwtTokenProvider;

    @Test
    public void deveRetornarUmaProvaResponseQuandoBuscarProvaPorTokenComQuestoesServiceForChamado() {
        ProvaResponse provaResponse = new ProvaResponse();
        Prova prova = new Prova();
        prova.setId(1L);
        prova.setStatus(StatusProva.ATIVA);
        String token = "token";
        provaResponse.setStatus(prova.getStatus());
        Mockito.when(jwtTokenProvider.getProvaId(token)).thenReturn(Optional.of(prova.getId()));
        Mockito.when(buscarProvaPorIdComQuestoesService.buscar(prova.getId())).thenReturn(provaResponse);

        Assert.assertEquals(provaResponse, buscarProvaPorTokenComQuestoesService.buscar(token));

    }

    @Test(expected = ProvaNaoEncontradaException.class)
    public void deveDispararProvaNaoEncontradaExceptionQuandoBuscarProvaPorTokenComQuestoesServiceForChamadoENaoRetornarUmaProva() {
        Prova prova = new Prova();
        prova.setId(1L);
        String token = "token";

        Mockito.when(jwtTokenProvider.getProvaId(token)).thenReturn(Optional.empty());

        buscarProvaPorTokenComQuestoesService.buscar(token);

    }

    @Test
    public void deveChamarJwtTokenProviderQuandoBuscarProvaPorTokenComQuestoesServiceForChamado() {
        ProvaResponse provaResponse = new ProvaResponse();
        Prova prova = new Prova();
        prova.setId(1L);
        prova.setStatus(StatusProva.ATIVA);
        String token = "token";
        provaResponse.setStatus(prova.getStatus());
        Mockito.when(jwtTokenProvider.getProvaId(token)).thenReturn(Optional.of(prova.getId()));
        Mockito.when(buscarProvaPorIdComQuestoesService.buscar(prova.getId())).thenReturn(provaResponse);

        buscarProvaPorTokenComQuestoesService.buscar(token);

        Mockito.verify(jwtTokenProvider).getProvaId(token);

    }

    @Test
    public void deveChamarBuscarProvaPorIdComQuestoesServiceQuandoBuscarProvaPorTokenComQuestoesServiceForChamado() {
        ProvaResponse provaResponse = new ProvaResponse();
        Prova prova = new Prova();
        prova.setId(1L);
        prova.setStatus(StatusProva.ATIVA);
        String token = "token";
        provaResponse.setStatus(prova.getStatus());
        Mockito.when(jwtTokenProvider.getProvaId(token)).thenReturn(Optional.of(prova.getId()));
        Mockito.when(buscarProvaPorIdComQuestoesService.buscar(prova.getId())).thenReturn(provaResponse);

        buscarProvaPorTokenComQuestoesService.buscar(token);

        Mockito.verify(buscarProvaPorIdComQuestoesService).buscar(prova.getId());

    }


}