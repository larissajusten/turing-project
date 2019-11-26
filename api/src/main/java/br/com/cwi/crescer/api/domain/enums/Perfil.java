package br.com.cwi.crescer.api.domain.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Perfil {

    ADMINISTRADOR("ROLE_ADMIN"),
    ENTREVISTADOR("ROLE_ENTREVISTADOR"),
    USUARIO("ROLE_USUARIO");

    private final String role;
}
