package br.com.cwi.crescer.api.controller.requests.questoes;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class BuscaQuestoesRequest {

    @NotNull(message = "A especificidade não pode ser vazia")
    private Especificidade especificidade;

    @NotNull(message = "O nivel de dificuldade não pode ser vazio")
    private NivelDeDificuldade nivelDeDificuldade;

    @NotNull(message = "A quantidade de questões não pode ser vazia")
    private int quantidadeDeQuestoes;

}