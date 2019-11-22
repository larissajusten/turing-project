package br.com.cwi.crescer.api.controller.requests.login;

import br.com.cwi.crescer.api.domain.enums.Perfil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioLogadoDTO {

    private String email;
    private String nome;
    private Perfil perfilAcesso;
    private String token;
}
