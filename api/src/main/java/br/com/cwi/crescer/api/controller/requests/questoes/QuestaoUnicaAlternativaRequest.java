package br.com.cwi.crescer.api.controller.requests.questoes;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Valid
public class QuestaoUnicaAlternativaRequest {

    @NotEmpty
    private String questao;

    @NotNull
    private Especificidade especificidade;

    @NotNull
    private NivelDeDificuldade nivelDeDificuldade;

}
