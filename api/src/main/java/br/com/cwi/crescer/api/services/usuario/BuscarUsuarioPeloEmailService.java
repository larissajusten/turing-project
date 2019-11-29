package br.com.cwi.crescer.api.services.usuario;

import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.exception.usuario.UsuarioNaoEncontradoException;
import br.com.cwi.crescer.api.repository.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarUsuarioPeloEmailService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario buscar(String email) {

        return repository.findByEmailEquals(email).orElseThrow(() ->
                new UsuarioNaoEncontradoException("Usuário não possui acesso à essa aplicação."));
    }
}
