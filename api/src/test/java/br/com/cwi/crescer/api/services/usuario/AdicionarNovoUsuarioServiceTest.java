package br.com.cwi.crescer.api.services.usuario;

import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.repository.UsuarioRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdicionarNovoUsuarioServiceTest {

    @InjectMocks
    AdicionarNovoUsuarioService adicionarNovoUsuarioService;

    @Mock
    UsuarioRepository repository;

    @Test
    public void deveChamarUsuarioRepositoryQuandoAdicionarNovoUsuarioServiceForChamado() {

        Usuario usuario = new Usuario();

        Mockito.when(repository.save(usuario)).thenReturn(usuario);

        adicionarNovoUsuarioService.adicionar(usuario);

        Mockito.verify(repository).save(usuario);
    }
}