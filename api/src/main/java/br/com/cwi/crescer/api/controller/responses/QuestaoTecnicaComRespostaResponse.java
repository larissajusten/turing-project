package br.com.cwi.crescer.api.controller.responses;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestaoTecnicaComRespostaResponse {

    private Especificidade especificidade;

    private Long idQuestao;

    private String resposta;

    private String questao;

    private String comentario;

    private double nota;

}
