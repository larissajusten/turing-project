package br.com.cwi.crescer.api.services.usuario;

import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.exception.usuario.UsuarioNaoEncontradoException;
import br.com.cwi.crescer.api.repository.UsuarioRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class BuscarUsuarioPeloEmailServiceTest {

    @InjectMocks
    BuscarUsuarioPeloEmailService buscarUsuarioPeloEmailService;

    @Mock
    private UsuarioRepository repository;

    @Test
    public void deveRetornarUmUsuarioQuandoBuscarUsuarioPeloEmailServiceForChamado() {

        String email = "a@mail.com";
        Usuario usuario = new Usuario();

        Mockito.when(repository.findByEmailEquals(email)).thenReturn(Optional.of(usuario));

        Assert.assertEquals(usuario, buscarUsuarioPeloEmailService.buscar(email));
    }

    @Test(expected = UsuarioNaoEncontradoException.class)
    public void deveDispararUmaExeceptionQuandoBuscarUsuarioPeloEmailServiceForChamado() {

        String email = "a@mail.com";
        Usuario usuario = new Usuario();

        Mockito.when(repository.findByEmailEquals(email)).thenReturn(Optional.empty());

        Assert.assertEquals(usuario, buscarUsuarioPeloEmailService.buscar(email));
    }
}