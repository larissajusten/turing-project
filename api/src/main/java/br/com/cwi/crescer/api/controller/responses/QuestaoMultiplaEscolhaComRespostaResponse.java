package br.com.cwi.crescer.api.controller.responses;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestaoMultiplaEscolhaComRespostaResponse {

    private Long idQuestao;

    private AlternativaMultiplaEscolha resposta;

    private String questao;

    private Especificidade especificidade;

    private double nota;

    private List<AlternativaMultiplaEscolha> alternativasMultiplaEscolhas;
}
