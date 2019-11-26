package br.com.cwi.crescer.api.security;

import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class LoggedUser implements Serializable {

    private Long id;

    private String matricula;

    private String login;

    private String nome;

    private String email;

//    private Set roles;
}

