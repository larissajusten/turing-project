package br.com.cwi.crescer.api.controller.responses;


import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespostaParaDashboardResponse {

    private NivelDeDificuldade nivelDeDificuldade;

    private double notaQuestao;

    private Long totalDePessoas;

}
