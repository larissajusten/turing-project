package br.com.cwi.crescer.api.services.login;

import br.com.cwi.crescer.api.domain.usuario.LoggedUserDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.stereotype.Service;

@Service
public class DecodificacaoTokenService {

    @Autowired
    private ObjectMapper objectMapper;

    public LoggedUserDTO decodificacaoToken(String token) {
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
