package br.com.cwi.crescer.api.controller.usuario;

import br.com.cwi.crescer.api.controller.requests.usuario.UsuarioRequest;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.services.usuario.AdicionarNovoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private AdicionarNovoUsuarioService adicionarNovoUsuarioService;

    //@RolesAllowed("Usuario")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Usuario adicionarUsuario(@Valid @RequestBody UsuarioRequest usuario) {

        return adicionarNovoUsuarioService.adicionar(usuario);
    }
}
