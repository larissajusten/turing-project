package br.com.cwi.crescer.api.controller;

import br.com.cwi.crescer.api.domain.usuario.LoggedUser;
import br.com.cwi.crescer.api.domain.usuario.LoggedUserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private LoggedUser user;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public String sayHello() {
        return "Hello " + user.getIdentifier();
    }

    @GetMapping("/user")
    public LoggedUserDTO viewUserInfo() {
        return modelMapper.map(user, LoggedUserDTO.class);
    }

}

