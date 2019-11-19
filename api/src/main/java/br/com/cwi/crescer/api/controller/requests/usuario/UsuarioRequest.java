package br.com.cwi.crescer.api.controller.requests.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Valid
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {

    @NotNull(message = "O id do usuario não pode ser vazio")
    private Long id;

    @NotNull(message = "O email do usuario não pode ser vazio")
    private String email;

    @NotNull(message = "A senha do usuario não pode ser vazia")
    private String senha;
}
