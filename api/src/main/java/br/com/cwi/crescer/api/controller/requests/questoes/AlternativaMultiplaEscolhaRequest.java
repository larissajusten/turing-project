package br.com.cwi.crescer.api.controller.requests.questoes;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class AlternativaMultiplaEscolhaRequest {

    @NotEmpty(message = "A alternativa não pode ser vazia")
    private String resposta;

    @NotNull(message = "A resposta correta não pode ser vazia")
    private boolean respostaCorreta;
}
