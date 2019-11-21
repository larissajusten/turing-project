package br.com.cwi.crescer.api.controller.usuario;

import br.com.cwi.crescer.api.controller.requests.usuario.UsuarioRequest;
import br.com.cwi.crescer.api.domain.enums.Perfil;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.services.usuario.FazerLoginDoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private FazerLoginDoUsuarioService fazerLoginDoUsuarioService;

    //@RolesAllowed("Usuario")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Usuario fazerLoginDoUsuario(@Valid @RequestBody UsuarioRequest usuario) {
        return fazerLoginDoUsuarioService.verificar(usuario);
    }
}
