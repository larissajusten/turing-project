package br.com.cwi.crescer.api.services.usuario;

import br.com.cwi.crescer.api.controller.requests.usuario.UsuarioRequest;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.repository.UsuarioRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class FazerLoginDoUsuarioServiceTest {

    @InjectMocks
    FazerLoginDoUsuarioService fazerLoginDoUsuarioService;

    @Mock
    BuscarUsuarioPeloEmailService buscarUsuarioPeloEmailService;


    @Test
    public void deveRetornarUmUsuarioQuandoFazerLoginDoUsuarioServiceForChamado() {

        UsuarioRequest request = new UsuarioRequest();
        Usuario usuario = new Usuario();

        Mockito.when(buscarUsuarioPeloEmailService.buscar(request.getEmail())).thenReturn(usuario);

        Assert.assertEquals(usuario, fazerLoginDoUsuarioService.verificar(request));
    }

    @Test
    public void deveChamarBuscarUsuarioPeloEmailServiceQuandoFazerLoginDoUsuarioServiceForChamado() {

        UsuarioRequest request = new UsuarioRequest();
        Usuario usuario = new Usuario();

        Mockito.when(buscarUsuarioPeloEmailService.buscar(request.getEmail())).thenReturn(usuario);

        fazerLoginDoUsuarioService.verificar(request);

        Mockito.verify(buscarUsuarioPeloEmailService).buscar(request.getEmail());
    }

}