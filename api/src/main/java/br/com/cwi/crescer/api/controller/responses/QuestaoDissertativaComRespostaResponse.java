package br.com.cwi.crescer.api.controller.responses;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestaoDissertativaComRespostaResponse {

    private Long idQuestao;

    private String resposta;

    private String comentario;

    private String questao;

    private Especificidade especificidade;

    private double nota;
}
