package br.com.cwi.crescer.api.services.usuario;

import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.exception.usuario.UsuarioNaoEncontradoException;
import br.com.cwi.crescer.api.repository.usuario.UsuarioRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class BuscarUsuarioPorIdServiceTest {

    @InjectMocks
    BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Mock
    UsuarioRepository repository;

    @Test
    public void deveRetornarUmUsuarioQuandoBuscarUsuarioPorIdServiceForChamado() {

        Usuario usuario = new Usuario();

        Mockito.when(repository.findById(usuario.getId())).thenReturn(Optional.of(usuario));

        Assert.assertEquals(usuario, buscarUsuarioPorIdService.buscar(usuario.getId()));

    }

    @Test
    public void deveChamarUsuarioRepositoryQuandoBuscarUsuarioPorIdServiceForChamado() {

        Usuario usuario = new Usuario();

        Mockito.when(repository.findById(usuario.getId())).thenReturn(Optional.of(usuario));

        buscarUsuarioPorIdService.buscar(usuario.getId());

        Mockito.verify(repository).findById(usuario.getId());

    }

    @Test(expected = UsuarioNaoEncontradoException.class)
    public void deveDispararUmaExceptionQuandoBuscarUsuarioPorIdServiceEOUsuarioNaoForEncontrado() {

        Usuario usuario = new Usuario();

        Mockito.when(repository.findById(usuario.getId())).thenReturn(Optional.empty());

        Assert.assertEquals(usuario, buscarUsuarioPorIdService.buscar(usuario.getId()));
    }
}