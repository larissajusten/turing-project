package br.com.cwi.crescer.api.controller.responses;

import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestaoMultiplaEscolhaParaCorrecaoResponse {

    private Long idQuestao;

    private AlternativaMultiplaEscolha resposta;

    private String questao;

}
