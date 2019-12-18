package br.com.cwi.crescer.api.controller.requests.prova;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class CandidatoRequest {

    @NotEmpty(message = "O email do candidato não pode ser vazio")
    private String email;

    @NotEmpty(message = "Deve ter o nome completo do candidato")
    private String nomeCandidato;

}
