package br.com.cwi.crescer.api.controller.requests.questoes;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class BuscaQuestoesRequest {

    @NotNull(message = "Especificidade não pode ser nulo" )
    private Especificidade especificidade;

    @NotNull(message = "Nível de dificuldade não pode ser nulo" )
    private NivelDeDificuldade nivelDeDificuldade;

    @NotNull(message = "Quantidade de questões da prova não pode ser nulo" )
    private int quantidadeDeQuestoes;

}