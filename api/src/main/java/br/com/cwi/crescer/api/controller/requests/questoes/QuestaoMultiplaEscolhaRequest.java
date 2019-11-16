package br.com.cwi.crescer.api.controller.requests.questoes;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@Valid
public class QuestaoMultiplaEscolhaRequest {

    @NotBlank
    private String questao;

    @NotNull
    private NivelDeDificuldade nivelDeDificuldade;

    @NotNull
    private Especificidade especificidade;

    @NotNull
    private AlternativaMultiplaEscolhaRequest alternativaA;

    @NotNull
    private AlternativaMultiplaEscolhaRequest alternativaB;

    @NotNull
    private AlternativaMultiplaEscolhaRequest alternativaC;

    @NotNull
    private AlternativaMultiplaEscolhaRequest alternativaD;

    @NotNull
    private AlternativaMultiplaEscolhaRequest alternativaE;

}
