package br.com.cwi.crescer.api.domain.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoggedUserDTO {

    private Long id;

    private String matricula;

    private String identifier;

    private String nome;

    private String email;

    private String token;

}
