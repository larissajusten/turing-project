package br.com.cwi.crescer.api.domain.usuario;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoggedUser implements Serializable {

    private String matricula;

    private String identifier;

    private String nome;

    private String email;

}
