package br.com.cwi.crescer.api.services.autenticacao;

import br.com.cwi.crescer.api.domain.enums.Perfil;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.exception.usuario.UsuarioNaoAutorizadoException;
import br.com.cwi.crescer.api.security.LoggedUser;
import br.com.cwi.crescer.api.services.usuario.BuscarUsuarioPeloEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificarPerfilUsuarioLogadoService {

    @Autowired
    private LoggedUser loggedUser;

    @Autowired
    private BuscarUsuarioPeloEmailService buscarUsuarioPeloEmailService;

    public void verificar(LoggedUser loggedUser) {

        Usuario usuario = buscarUsuarioPeloEmailService.buscar(loggedUser.getLogin());

        if (usuario.getPerfil().equals(Perfil.ENTREVISTADOR)) {
            throw new UsuarioNaoAutorizadoException("Usuário não autorizado");
        }
    }

}
