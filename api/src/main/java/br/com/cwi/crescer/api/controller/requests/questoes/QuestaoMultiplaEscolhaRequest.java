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

    @NotBlank (message = "A questão não pode ser vazia")
    private String questao;

    @NotNull (message = "O nivel de dificuldade não pode ser vazio")
    private NivelDeDificuldade nivelDeDificuldade;

    @NotNull (message = "A especificidade não pode ser vazia")
    private Especificidade especificidade;

    @NotNull (message = "A alternativa A não pode ser vazia")
    private AlternativaMultiplaEscolhaRequest alternativaA;

    @NotNull (message = "A alternativa B não pode ser vazia")
    private AlternativaMultiplaEscolhaRequest alternativaB;

    @NotNull (message = "A alternativa C não pode ser vazia")
    private AlternativaMultiplaEscolhaRequest alternativaC;

    @NotNull (message = "A alternativa D não pode ser vazia")
    private AlternativaMultiplaEscolhaRequest alternativaD;

    @NotNull (message = "A alternativa E não pode ser vazia")
    private AlternativaMultiplaEscolhaRequest alternativaE;

}
