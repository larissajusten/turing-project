package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.exception.prova.ProvaNaoEncontradaException;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class BuscarProvaCriadaPorEmailDoCandidatoServiceTest {

    @InjectMocks
    BuscarProvaCriadaPorEmailDoCandidatoService buscarProvaCriadaPorEmailDoCandidatoService;

    @Mock
    ProvaRepository repository;

    @Test
    public void deveRetornarUmaProvaQuandoBuscarProvaAtivaPorEmailDoCandidatoServiceForChamado() {

        String email = "mail@mail.com";

        Prova prova = new Prova();
        prova.setStatus(StatusProva.ATIVA);

        Mockito.when(repository.findByEmailCandidatoEqualsAndStatusEquals(email, StatusProva.ATIVA))
                .thenReturn(Optional.of(prova));


        Assert.assertEquals(prova, buscarProvaCriadaPorEmailDoCandidatoService.buscar(email));

    }

    @Test(expected = ProvaNaoEncontradaException.class)
    public void develancarUmaProvaNaoEncontradaExceptionQuandoBuscarProvaAtivaPorEmailDoCandidatoServiceForChamadoENaoRetornarUmaProva() {

        String email = "mail@mail.com";

        Prova prova = new Prova();
        prova.setStatus(StatusProva.CORRIGIDA);

        Mockito.when(repository.findByEmailCandidatoEqualsAndStatusEquals(email, StatusProva.ATIVA))
                .thenReturn(Optional.empty());


        buscarProvaCriadaPorEmailDoCandidatoService.buscar(email);

    }
}