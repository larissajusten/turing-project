package br.com.cwi.crescer.api.controller.requests.questoes;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class QuestaoTecnicaRequest {

    @NotEmpty(message = "Questão não pode estar vazio")
    private String questao;

    @NotNull(message = "Especificidade não pode ser nula")
    private Especificidade especificidade;

    @NotNull(message = "Nível de dificuldade não pode ser nula")
    private NivelDeDificuldade nivelDeDificuldade;

    @NotEmpty(message = "Teste base não pode estar vazio")
    private String testeBase;

    @NotEmpty(message = "Resposta base não pode estar vazio")
    private String respostaBase;
}
