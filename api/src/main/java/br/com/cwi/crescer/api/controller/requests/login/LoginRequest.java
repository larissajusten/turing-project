package br.com.cwi.crescer.api.controller.requests.login;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @NotEmpty (message = "O email não pode ser vazio")
    private String login;

    private String senha;

}
