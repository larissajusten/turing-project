package br.com.cwi.crescer.api.controller.requests.questoes;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
public class AlternativaMultiplaEscolhaRequest {

    @NotEmpty
    private String resposta;

    @NotEmpty
    private boolean respostaCorreta;
}
