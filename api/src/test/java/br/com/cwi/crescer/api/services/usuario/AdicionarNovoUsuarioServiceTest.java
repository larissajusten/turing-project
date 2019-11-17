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
public class AdicionarNovoUsuarioServiceTest {

    @InjectMocks
    AdicionarNovoUsuarioService adicionarNovoUsuarioService;

    @Mock
    UsuarioRepository repository;

    @Mock
    ModelMapper mapper;

    @Test
    public void deveChamarModelMapperQuandoAdicionarNovoUsuarioServiceForChamado() {

        UsuarioRequest request = new UsuarioRequest();

        Usuario usuario = new Usuario();

        Mockito.when(mapper.map(request, Usuario.class)).thenReturn(usuario);
        Mockito.when(repository.save(usuario)).thenReturn(usuario);

        adicionarNovoUsuarioService.adicionar(request);

        Mockito.verify(mapper).map(request, Usuario.class);
    }

    @Test
    public void deveChamarUsuarioRepositoryQuandoAdicionarNovoUsuarioServiceForChamado() {

        UsuarioRequest request = new UsuarioRequest();

        Usuario usuario = new Usuario();

        Mockito.when(mapper.map(request, Usuario.class)).thenReturn(usuario);
        Mockito.when(repository.save(usuario)).thenReturn(usuario);

        adicionarNovoUsuarioService.adicionar(request);

        Mockito.verify(repository).save(usuario);
    }

    @Test
    public void deveRetornarUmUsuarioQuandoAdicionarNovoUsuarioServiceForChamado() {

        UsuarioRequest request = new UsuarioRequest();

        Usuario usuario = new Usuario();

        Mockito.when(mapper.map(request, Usuario.class)).thenReturn(usuario);
        Mockito.when(repository.save(usuario)).thenReturn(usuario);

        adicionarNovoUsuarioService.adicionar(request);

        Assert.assertEquals(adicionarNovoUsuarioService.adicionar(request), usuario);
    }
}