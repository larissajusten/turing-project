package br.com.cwi.crescer.api.config;

import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.security.ClaimTypes;
import br.com.cwi.crescer.api.security.LoggedUser;
import br.com.cwi.crescer.api.services.usuario.BuscarUsuarioPeloEmailService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.context.request.RequestContextListener;

@Slf4j
@Configuration
public class OAuth2ClientContextConfig {

    @Autowired
    private BuscarUsuarioPeloEmailService buscarUsuarioPeloEmailService;

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

    @Bean
    @Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, scopeName = "request")
    public LoggedUser getUserFromJwt(@Autowired OAuth2ClientContext context, @Autowired ObjectMapper mapper) {
        LoggedUser usuario = null;

        try {
            OAuth2AccessToken oAuth2AccessToken = context.getAccessToken();
            String token = oAuth2AccessToken.getValue();

            String claims = JwtHelper.decode(token).getClaims();

            JsonNode jsonNode = mapper.readTree(claims);

            String matricula = jsonNode.get(ClaimTypes.MATRICULA.toString()).asText();
            String login = jsonNode.get(ClaimTypes.NAMEIDENTIFIER.toString()).asText();
            String nome = jsonNode.get(ClaimTypes.NAME.toString()).asText();
            String email = jsonNode.get(ClaimTypes.EMAILADDRESS.toString()).asText();

            Usuario colaborador = buscarUsuarioPeloEmailService.buscar(login);
            String role = colaborador.getPerfil().getRole();

            usuario = new LoggedUser(matricula, login, nome, email, Sets.newHashSet(role));
        } catch (Exception e) {
            log.error("Erro no conversão", e);
        }

        return usuario;
    }

    @Bean
    @Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, scopeName = "request")
    public OAuth2AccessToken getAcessToken(@Autowired OAuth2ClientContext context) {
        return context.getAccessToken();
    }

}
