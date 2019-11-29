package br.com.cwi.crescer.api.services.login;

import br.com.cwi.crescer.api.domain.login.AccessTokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class PegarTokenDeAcessoService {

    @Autowired
    private RestTemplate restTemplate;

    public String getAccessToken(String login, String senha) {

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
}
