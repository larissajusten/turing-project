package br.com.cwi.crescer.api.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class LoggedUser {

    private Long id;

    private String matricula;

    private String login;

    private String nome;

    private String email;

    private Set roles;
}

