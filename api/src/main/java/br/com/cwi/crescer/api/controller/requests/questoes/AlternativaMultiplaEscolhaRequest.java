package br.com.cwi.crescer.api.controller.requests.questoes;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
public class AlternativaMultiplaEscolhaRequest {

    @NotEmpty(message = "A alternativa não pode ser vazia")
    private String resposta;

    @NotEmpty(message = "A resposta correta não pode ser vazia")
    private boolean respostaCorreta;
}
