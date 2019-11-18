package br.com.cwi.crescer.api.controller.requests.questoes;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
public class AlternativaMultiplaEscolhaRequest {

    @NotEmpty(message = "Resposta não pode estar vazia")
    private String resposta;

    @NotEmpty(message = "Resposta correta não pode estar vazia" )
    private boolean respostaCorreta;
}
