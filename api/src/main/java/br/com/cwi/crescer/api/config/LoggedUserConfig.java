package br.com.cwi.crescer.api.config;

import br.com.cwi.crescer.api.domain.usuario.LoggedUser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

@Slf4j
@Configuration
public class LoggedUserConfig {

    @Autowired
    private OAuth2ClientContext context;

    @Autowired
    private ObjectMapper mapper;

    @Bean
    @Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, scopeName = "request")
    public LoggedUser getUserFromJwt() {

        LoggedUser usuario = null;
        try {
            OAuth2AccessToken oAuth2AccessToken = context.getAccessToken();
            String token = oAuth2AccessToken.getValue();

            String claims = JwtHelper.decode(token).getClaims();

            JsonNode jsonNode = mapper.readTree(claims);
            String matricula = jsonNode.get("matricula").asText();
            String identifier = jsonNode.get("http://schemas.xmlsoap.org/ws/2005/05/identity/claims/nameidentifier").asText();
            String name = jsonNode.get("http://schemas.xmlsoap.org/ws/2005/05/identity/claims/name").asText();
            String email = jsonNode.get("http://schemas.xmlsoap.org/ws/2005/05/identity/claims/emailaddress").asText();

            usuario = new LoggedUser(matricula, identifier, name, email);
        } catch (Exception e) {
            log.error("Erro no conversão", e);
        }

        return usuario;
    }


}