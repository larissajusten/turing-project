package br.com.cwi.crescer.api.services.autenticacao;

import br.com.cwi.crescer.api.domain.enums.Perfil;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.exception.usuario.UsuarioNaoAutorizadoException;
import br.com.cwi.crescer.api.security.LoggedUser;
import br.com.cwi.crescer.api.services.usuario.BuscarUsuarioPeloEmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class VerificarPerfilUsuarioLogadoServiceTest {

    @InjectMocks
    VerificarPerfilUsuarioLogadoService verificarPerfilUsuarioLogadoService;

    @Mock
    LoggedUser loggedUser;

    @Mock
    BuscarUsuarioPeloEmailService buscarUsuarioPeloEmailService;

    @Test
    public void deveChamarBuscarUsuarioPeloEmailServiceQuandoVerificarPerfilUsuarioLogadoServiceForChamado() {

        Usuario usuario = new Usuario();
        usuario.setPerfil(Perfil.ADMINISTRADOR);

        Mockito.when(buscarUsuarioPeloEmailService.buscar(loggedUser.getLogin()))
                .thenReturn(usuario);

        verificarPerfilUsuarioLogadoService.verificar(loggedUser);

        Mockito.verify(buscarUsuarioPeloEmailService).buscar(loggedUser.getLogin());
    }

    @Test(expected = UsuarioNaoAutorizadoException.class)
    public void deveLancarUsuarioNaoAutorizadoExceptionQuandoPerfilDoUsuarioForEntrevistador() {

        Usuario usuario = new Usuario();
        usuario.setPerfil(Perfil.ENTREVISTADOR);

        Mockito.when(buscarUsuarioPeloEmailService.buscar(loggedUser.getLogin()))
                .thenReturn(usuario);

        verificarPerfilUsuarioLogadoService.verificar(loggedUser);

        Mockito.verify(buscarUsuarioPeloEmailService).buscar(loggedUser.getLogin());
    }
}