package br.com.cwi.crescer.api.services.usuario;

import br.com.cwi.crescer.api.controller.requests.usuario.UsuarioRequest;
import br.com.cwi.crescer.api.domain.enums.Perfil;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FazerLoginDoUsuarioService {

    @Autowired
    private BuscarUsuarioPeloEmailService buscarUsuarioPeloEmailService;

    public Usuario verificar(UsuarioRequest request) {
        Usuario usuario = buscarUsuarioPeloEmailService.buscar(request.getEmail());

        return usuario;
    }

}
