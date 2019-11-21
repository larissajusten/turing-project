package br.com.cwi.crescer.api.domain.usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoggedUserDTO {

    private String matricula;

    private String identifier;

    private String nome;

    private String email;

}
