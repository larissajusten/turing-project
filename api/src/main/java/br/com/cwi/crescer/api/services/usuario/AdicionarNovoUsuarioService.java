package br.com.cwi.crescer.api.services.usuario;

import br.com.cwi.crescer.api.controller.requests.usuario.UsuarioRequest;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdicionarNovoUsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ModelMapper mapper;

    public void adicionar(UsuarioRequest request) {

        Usuario usuario = mapper.map(request, Usuario.class);

        repository.save(usuario);
    }

}
