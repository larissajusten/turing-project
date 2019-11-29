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
public class QuestaoMultiplaEscolhaRequest {

    @NotBlank(message = "Questão deve estar preenchido")
    private String questao;

    @NotNull(message = "Nível de dificuldade não pode ser nulo")
    private NivelDeDificuldade nivelDeDificuldade;

    @NotNull(message = "Especificidade não pode ser nula")
    private Especificidade especificidade;

    @Valid
    private AlternativaMultiplaEscolhaRequest alternativaA;

    @Valid
    private AlternativaMultiplaEscolhaRequest alternativaB;

    @Valid
    private AlternativaMultiplaEscolhaRequest alternativaC;

    @Valid
    private AlternativaMultiplaEscolhaRequest alternativaD;

    @Valid
    private AlternativaMultiplaEscolhaRequest alternativaE;
}
