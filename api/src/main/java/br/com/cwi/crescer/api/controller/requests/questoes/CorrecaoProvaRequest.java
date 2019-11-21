package br.com.cwi.crescer.api.controller.requests.questoes;

import br.com.cwi.crescer.api.domain.enums.TipoDeQuestao;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class CorrecaoProvaRequest {

    @NotNull
    private Long idQuestao;

    @NotNull
    private Long idResposta;

    private TipoDeQuestao tipoDeQuestao;

    @NotNull(message = "A nota não pode ser vazia")
    private double nota;

    @NotEmpty(message = "O comentario não pode ser vazio")
    private String comentario;

}
