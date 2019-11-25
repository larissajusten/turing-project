package br.com.cwi.crescer.api.controller.login;

import br.com.cwi.crescer.api.controller.requests.login.LoginRequest;
import br.com.cwi.crescer.api.domain.usuario.LoggedUserDTO;
import br.com.cwi.crescer.api.services.login.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public LoggedUserDTO efetuarLogin(@Valid @RequestBody LoginRequest loginRequest) {

        return loginService.logar(loginRequest);
    }
}