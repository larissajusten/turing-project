package br.com.cwi.crescer.api.services.login;

import br.com.cwi.crescer.api.controller.requests.login.LoginRequest;
import br.com.cwi.crescer.api.domain.usuario.LoggedUserDTO;
import br.com.cwi.crescer.api.services.usuario.BuscarUsuarioPeloEmailService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {


    @InjectMocks
    LoginService loginService;

    @Mock
    BuscarUsuarioPeloEmailService buscarUsuarioPeloEmailService;

    @Mock
    DecodificacaoTokenService decodificacaoToken;

    @Mock
    ModelMapper mapper;

    @Mock
    PegarTokenDeAcessoService pegarToken;


    @Test
    public void deveRetornarUmLoggedUserDTOQuandoLoginServiceForChamado() {

        LoginRequest loginRequest = new LoginRequest();
        LoggedUserDTO loggedUserDTO = new LoggedUserDTO();

        String token = "token";

        Mockito.when(pegarToken.getAccessToken(loginRequest.getLogin(), loginRequest.getSenha())).thenReturn(token);
        Mockito.when(decodificacaoToken.decodificacaoToken(token)).thenReturn(loggedUserDTO);

        Assert.assertEquals(loggedUserDTO, loginService.logar(loginRequest));


    }
}