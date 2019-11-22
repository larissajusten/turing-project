package br.com.cwi.crescer.api.services.usuario;

import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.exception.ValidacaoDeAplicacaoException;
import br.com.cwi.crescer.api.exception.usuario.UsuarioNaoEncontradoException;
import br.com.cwi.crescer.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarUsuarioPorIdService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario buscar(Long id){
        return repository.findById(id).orElseThrow(() -> new UsuarioNaoEncontradoException("Usuaurio nao encontrado"));
    }
}
