package br.com.cwi.crescer.api.security;

import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.services.usuario.BuscarUsuarioPeloEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class RolesExtractor implements AuthoritiesExtractor {

    @Autowired
    private BuscarUsuarioPeloEmailService buscarColaboradorPorLoginService;

    @Override
    public List<GrantedAuthority> extractAuthorities(Map<String, Object> map) {
        String login = (String) map.get(ClaimTypes.NAMEIDENTIFIER.toString());

        Usuario colaborador = buscarColaboradorPorLoginService.buscar(login);

        String role = colaborador.getPerfil().getRole();

        return AuthorityUtils.commaSeparatedStringToAuthorityList(role);
    }
}
