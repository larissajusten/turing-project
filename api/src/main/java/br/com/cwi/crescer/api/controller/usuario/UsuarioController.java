package br.com.cwi.crescer.api.controller.usuario;

import br.com.cwi.crescer.api.controller.requests.usuario.UsuarioRequest;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.services.usuario.AdicionarNovoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private AdicionarNovoUsuarioService adicionarNovoUsuarioService;

    @PostMapping
    public void adicionarUsuario(@RequestBody UsuarioRequest usuario) {

        adicionarNovoUsuarioService.adicionar(usuario);
    }
}
