package br.com.cwi.crescer.api.controller.requests.questoes;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
@Valid
public class QuestaoTecnicaRequest {

    @NotEmpty
    private String questao;

    @NonNull
    private NivelDeDificuldade nivelDeDificuldade;

    @NonNull
    private Especificidade especificidade;

}
