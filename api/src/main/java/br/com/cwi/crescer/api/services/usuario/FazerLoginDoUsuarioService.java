package br.com.cwi.crescer.api.services.usuario;

import br.com.cwi.crescer.api.controller.requests.usuario.UsuarioRequest;
import br.com.cwi.crescer.api.domain.enums.Perfil;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FazerLoginDoUsuarioService {

    @Autowired
    private BuscarUsuarioPeloEmailService buscarUsuarioPeloEmailService;

    public Perfil verificar(String nome) {
        Usuario usuario = buscarUsuarioPeloEmailService.buscar(nome);

        return usuario.getPerfil();
    }

}
