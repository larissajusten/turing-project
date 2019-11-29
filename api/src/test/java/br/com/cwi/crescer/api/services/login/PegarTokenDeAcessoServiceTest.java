package br.com.cwi.crescer.api.services.login;

import br.com.cwi.crescer.api.domain.login.AccessTokenDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class PegarTokenDeAcessoServiceTest {

    @InjectMocks
    PegarTokenDeAcessoService pegarTokenDeAcessoService;

    @Mock
    RestTemplate restTemplate;

    @Test
    public void deveChamar() {

        String login = "admin";
        String senha = "adm";

        AccessTokenDto accessTokenDto = new AccessTokenDto();
        String url = String.format("%s/connect/token", "https://auth-homolog.cwi.com.br");

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

        Mockito.when(restTemplate.postForObject(url, request, AccessTokenDto.class)).thenReturn(accessTokenDto);
        Assert.assertEquals(accessTokenDto.getAccesToken(), pegarTokenDeAcessoService.getAccessToken(login, senha));

    }


}