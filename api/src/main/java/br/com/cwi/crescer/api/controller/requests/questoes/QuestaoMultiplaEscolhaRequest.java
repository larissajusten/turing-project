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

    @NotBlank(message = "Questão deve estar preenchido" )
    private String questao;

    @NotNull(message = "Nível de dificuldade não pode ser nulo" )
    private NivelDeDificuldade nivelDeDificuldade;

    @NotNull(message = "Especificidade não pode ser nula" )
    private Especificidade especificidade;

    @NotNull(message = "Alternativa A não pode ser nula" )
    private AlternativaMultiplaEscolhaRequest alternativaA;

    @NotNull(message = "Alternativa B não pode ser nula" )
    private AlternativaMultiplaEscolhaRequest alternativaB;

    @NotNull(message = "Alternativa C não pode ser nula" )
    private AlternativaMultiplaEscolhaRequest alternativaC;

    @NotNull(message = "Alternativa D não pode ser nula" )
    private AlternativaMultiplaEscolhaRequest alternativaD;

    @NotNull(message = "Alternativa E não pode ser nula" )
    private AlternativaMultiplaEscolhaRequest alternativaE;

}
