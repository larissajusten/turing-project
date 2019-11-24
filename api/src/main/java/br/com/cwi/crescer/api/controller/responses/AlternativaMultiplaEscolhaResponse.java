package br.com.cwi.crescer.api.controller.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlternativaMultiplaEscolhaResponse {

    private Long idAlternativa;

    private Long idQuestao;

    private String resposta;

    private boolean respostaCorreta;

}
