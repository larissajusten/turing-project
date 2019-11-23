package br.com.cwi.crescer.api.services.login;

import br.com.cwi.crescer.api.controller.requests.login.LoginRequest;
import br.com.cwi.crescer.api.domain.login.AccessTokenDto;
import br.com.cwi.crescer.api.domain.usuario.LoggedUserDTO;
import br.com.cwi.crescer.api.services.usuario.BuscarUsuarioPeloEmailService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BuscarUsuarioPeloEmailService buscarUsuarioPeloEmailService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ModelMapper mapper;

    public String logar(LoginRequest loginRequest) {
        String token = getAccessToken(loginRequest.getLogin(), loginRequest.getSenha());

        LoggedUserDTO usuario = decodificacaoToken(token);
        usuario.setToken("Bearer " + token);

        return usuario.getToken();

    }

    private String getAccessToken(String login, String senha) {

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("username", login);
        form.add("password", senha);
        form.add("client_id", "clima-app");
        form.add("client_secret", "clima-homologacao");
        form.add("grant_type", "password");
        form.add("scopes", "clima-api openid");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(form, header);
        String url = String.format("%s/connect/token", "https://auth-homolog.cwi.com.br");
        AccessTokenDto accessTokenDto = restTemplate.postForObject(url, request, AccessTokenDto.class);
        return accessTokenDto.getAccesToken();
    }

    private LoggedUserDTO decodificacaoToken(String token) {
        LoggedUserDTO usuarioLogado = new LoggedUserDTO();
        String decoded = JwtHelper.decode(token).getClaims();
        try {
            JsonNode jsonNode = objectMapper.readTree(decoded);
            usuarioLogado
                    .setIdentifier(jsonNode
                            .get("http://schemas.xmlsoap.org/ws/2005/05/identity/claims/nameidentifier").asText());
            usuarioLogado
                    .setNome(jsonNode
                            .get("http://schemas.xmlsoap.org/ws/2005/05/identity/claims/name").asText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarioLogado;
    }



}
