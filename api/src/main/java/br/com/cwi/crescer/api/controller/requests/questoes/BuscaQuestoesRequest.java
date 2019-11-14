package br.com.cwi.crescer.api.controller.requests.questoes;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class BuscaQuestoesRequest {

    @NotNull
    private Especificidade especificidade;

    @NotNull
    private NivelDeDificuldade nivelDeDificuldade;

    @NotEmpty
    private int quantidadeDeQuestoes;

}