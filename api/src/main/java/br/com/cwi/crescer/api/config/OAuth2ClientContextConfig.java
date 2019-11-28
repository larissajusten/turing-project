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
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.context.request.RequestContextListener;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Slf4j
 //TODO Vanessa Schenkel 23/11/2019 - Pesquisar sobre slf4j
@Configuration
public class OAuth2ClientContextConfig {

    @Autowired
    private BuscarUsuarioPeloEmailService buscarUsuarioPeloEmailService;

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

    @Autowired
    private OAuth2ClientContext context;

    @Autowired
    private ObjectMapper mapper;

    @Bean
    @Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, scopeName = "request")
    public LoggedUser getUserFromJwt() {
        LoggedUser usuario = null;

//        List<GrantedAuthority> authorities = user.getRoles().stream()
//                .map(authority -> new SimpleGrantedAuthority(authority.getRole().authority()))
//                .collect(Collectors.toList());

        try {
            OAuth2AccessToken oAuth2AccessToken = context.getAccessToken();
            String token = oAuth2AccessToken.getValue();

            String claims = JwtHelper.decode(token).getClaims();

//            Claims claims2 = Jwts.claims().setSubject(username);
//            claims.put("auth", roles.stream().map(s -> new SimpleGrantedAuthority(s.getAuthority())).filter(Objects::nonNull).collect(Collectors.toList()));

//            SimpleGrantedAuthority auth = new SimpleGrantedAuthority("ROLE_" + role.getName());

            JsonNode jsonNode = mapper.readTree(claims);

            String matricula = jsonNode.get(ClaimTypes.MATRICULA.toString()).asText();
            String login = jsonNode.get(ClaimTypes.NAMEIDENTIFIER.toString()).asText();
            String nome = jsonNode.get(ClaimTypes.NAME.toString()).asText();
            String email = jsonNode.get(ClaimTypes.EMAILADDRESS.toString()).asText();
//            String role = jsonNode.get(ClaimTypes.)

            Usuario colaborador = buscarUsuarioPeloEmailService.buscar(login);
//            String role = colaborador.getPerfil().getRole();

//            Set authorities = new HashSet<>();
//            authorities.add(new SimpleGrantedAuthority("ROLE_KKKKKKKKK"));

//            usuario = new LoggedUser(colaborador.getId(), matricula, login, nome, email);
//            usuario = new LoggedUser(colaborador.getId(), matricula, login, nome, email, Sets.newHashSet(role));
        } catch (Exception e) {
            log.error("Erro no conversão", e);
        }

        return usuario;
    }


}
