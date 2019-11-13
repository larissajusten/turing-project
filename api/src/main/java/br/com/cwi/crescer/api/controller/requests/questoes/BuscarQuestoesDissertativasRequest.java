package br.com.cwi.crescer.api.controller.requests.questoes;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
public class BuscarQuestoesDissertativasRequest {

    @NonNull
    private Especificidade especificidade;

    @NonNull
    private NivelDeDificuldade nivelDeDificuldade;

    @NotEmpty
    private int quantidadeDeQuestoes;
}
