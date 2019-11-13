package br.com.cwi.crescer.api.controller.requests.questoes;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@Valid
public class QuestaoDissertativaRequest {

    @NotEmpty
    private String questao;

    @NonNull
    private NivelDeDificuldade nivelDeDificuldade;

    @NonNull
    private Especificidade especificidade;

}
