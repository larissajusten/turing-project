package br.com.cwi.crescer.api.controller.requests.questoes;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class QuestaoUnicaAlternativaRequest {


    @NotEmpty(message = "A questao não pode ser vazia")
    private String questao;

    @NotNull (message = "A especificidade não pode ser vazia")
    private Especificidade especificidade;

    @NotNull (message = "O nivel de dificuldade não pode ser vazio")
    private NivelDeDificuldade nivelDeDificuldade;

}
