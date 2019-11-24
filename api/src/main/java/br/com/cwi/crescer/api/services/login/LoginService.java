package br.com.cwi.crescer.api.services.login;

import br.com.cwi.crescer.api.controller.requests.login.LoginRequest;
import br.com.cwi.crescer.api.domain.usuario.LoggedUserDTO;
import br.com.cwi.crescer.api.services.usuario.BuscarUsuarioPeloEmailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {


    @Autowired
    private BuscarUsuarioPeloEmailService buscarUsuarioPeloEmailService;

    @Autowired
    private DecodificacaoTokenService decodificacaoToken;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PegarTokenDeAcessoService pegarToken;

    public LoggedUserDTO logar(LoginRequest loginRequest) {
        String token = pegarToken.getAccessToken(loginRequest.getLogin(), loginRequest.getSenha());

        LoggedUserDTO usuario = decodificacaoToken.decodificacaoToken(token);
        usuario.setToken("Bearer " + token);

        return usuario;
    }



}
