package br.com.cwi.crescer.api.security;

import lombok.*;

import java.io.Serializable;
import java.util.HashSet;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoggedUser implements Serializable {

    private String matricula;

    private String login;

    private String nome;

    private String email;

    private HashSet<String> roles;

}

