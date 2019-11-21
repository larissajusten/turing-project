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

@RunWith(MockitoJUnitRunner.class)
public class FazerLoginDoUsuarioServiceTest {

    @InjectMocks
    FazerLoginDoUsuarioService fazerLoginDoUsuarioService;


    @Mock
    BuscarUsuarioPeloEmailService buscarUsuarioPeloEmailService;


    @Test
    public void deveRetornarUmUsuarioQuandoAdicionarNovoUsuarioServiceForChamado() {

        UsuarioRequest request = new UsuarioRequest();

        Usuario usuario = new Usuario();
        
        Assert.assertEquals(request.getEmail(), usuario.getEmail());
    }
}